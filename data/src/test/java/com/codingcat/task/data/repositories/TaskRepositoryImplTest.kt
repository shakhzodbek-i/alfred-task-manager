package com.codingcat.task.data.repositories

import arrow.core.Either
import arrow.core.raise.either
import com.codingcat.task.data.BaseTest
import com.codingcat.task.data.model.TaskLocalDto
import com.codingcat.task.data.model.TaskRemoteDto
import com.codingcat.task.data.model.map
import com.codingcat.task.data.model.mapToLocal
import com.codingcat.task.data.model.mapToRemote
import com.codingcat.task.data.repositories.local.TasksDao
import com.codingcat.task.data.repositories.remote.TasksRemoteDataSource
import com.codingcat.task.domain.models.HttpRequestError
import com.codingcat.task.domain.models.Task
import com.codingcat.task.domain.repositories.TaskRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Answers


class TaskRepositoryImplTest : BaseTest() {

    @MockK
    private lateinit var localDataSourceMock: TasksDao

    @MockK
    private lateinit var remoteDataSource: TasksRemoteDataSource

    private lateinit var repository: TaskRepository

    override fun setup() {
        super.setup()
        repository = TaskRepositoryImpl(localDataSourceMock, remoteDataSource)
    }

    @Test
    fun getAllTasks_getTaskListFromLocal_ifTasksInLocalDatabaseExists() = runTest {
        val taskLocalDtoMock = TaskLocalDto(
            id = 1,
            title = "testTitle",
            description = "testDescription",
            category = "testCategory",
            date = "testDate",
            startTime = "testStartTime",
            endTime = "testEndTime"
        )

        coEvery {
            localDataSourceMock.getAllTasks()
        } returns listOf(taskLocalDtoMock)

        launch {
            val tasks = repository.getAllTasks().orNull()

            assertThat(tasks).contains(taskLocalDtoMock.map())
        }
    }

    @Test
    fun getAllTasks_getTaskListFromRemote_ifTasksInLocalDatabaseNotExists() = runTest {
        val taskRemoteDtoMock = TaskRemoteDto(
            id = 1,
            title = "testTitle",
            description = "testDescription",
            category = "testCategory",
            date = "testDate",
            startTime = "testStartTime",
            endTime = "testEndTime"
        )

        coEvery {
            localDataSourceMock.getAllTasks()
        } returns emptyList()

        coEvery {
            remoteDataSource.getAllTasks()
        } returns either { listOf(taskRemoteDtoMock) }

        launch {
            val tasks = repository.getAllTasks().orNull()

            assertThat(tasks).contains(taskRemoteDtoMock.map())
        }
    }

    @Test
    fun getAllTasks_getErrorFromRemote_ifRemoteDataSourceUnreachable() = runTest {
        coEvery {
            localDataSourceMock.getAllTasks()
        } returns emptyList()

        coEvery {
            remoteDataSource.getAllTasks()
        } returns Either.Left(HttpRequestError.NetworkError)

        launch {
            val response = repository.getAllTasks()

            assertThat(response.isLeft()).isTrue()
        }
    }

    @Test
    fun addNewTask_getListOfTaskWithNewAddedTask() = runTest {
        val newTask = Task(
            id = 1,
            title = "testTitle",
            description = "testDescription",
            category = "testCategory",
            date = "testDate",
            startTime = "testStartTime",
            endTime = "testEndTime"
        )

        coEvery {
            localDataSourceMock.getAllTasks()
        } returns listOf(newTask.mapToLocal())

        coEvery {
            localDataSourceMock.insertTask(any())
        } returns Unit

        coEvery {
            remoteDataSource.addNewTask(any())
        } returns Either.Right(Unit)

        launch {
            repository.addNewTask(newTask)

            val tasks = repository.getAllTasks().orNull()

            assertThat(tasks).contains(newTask)
        }
    }

    @Test
    fun addNewTask_getError_ifRemoteNotReachable() = runTest {
        val newTask = Task(
            id = 1,
            title = "testTitle",
            description = "testDescription",
            category = "testCategory",
            date = "testDate",
            startTime = "testStartTime",
            endTime = "testEndTime"
        )

        coEvery {
            localDataSourceMock.getAllTasks()
        } returns listOf(newTask.mapToLocal())

        coEvery {
            localDataSourceMock.insertTask(any())
        } returns Unit

        coEvery {
            remoteDataSource.addNewTask(any())
        } returns Either.Left(HttpRequestError.NetworkError)

        launch {
            val response = repository.addNewTask(newTask)

            assertThat(response.isLeft()).isTrue()
        }
    }

    @Test
    fun deleteTask_() = runTest {
        val taskRemoteDtoMock = TaskRemoteDto(
            id = 1,
            title = "testTitle",
            description = "testDescription",
            category = "testCategory",
            date = "testDate",
            startTime = "testStartTime",
            endTime = "testEndTime"
        )

        coEvery {
            localDataSourceMock.getAllTasks()
        } returns emptyList()

        coEvery {
            remoteDataSource.getAllTasks()
        } returns either { listOf(taskRemoteDtoMock) }

        launch {
            val tasks = repository.getAllTasks().orNull()

            assertThat(tasks).contains(taskRemoteDtoMock.map())
        }
    }

    @Test
    fun addNewTask_getErrorFromRemote_ifRemoteDataSourceUnreachable() = runTest {
        coEvery {
            localDataSourceMock.getAllTasks()
        } returns emptyList()

        coEvery {
            remoteDataSource.getAllTasks()
        } returns Either.Left(HttpRequestError.NetworkError)

        launch {
            val response = repository.getAllTasks()

            assertThat(response.isLeft()).isTrue()
        }
    }
}