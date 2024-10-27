package com.codingcat.task.data.repositories

import arrow.core.Either
import arrow.core.raise.either
import com.codingcat.task.data.model.map
import com.codingcat.task.data.model.mapToLocal
import com.codingcat.task.data.model.mapToRemote
import com.codingcat.task.data.repositories.local.TasksDao
import com.codingcat.task.data.repositories.remote.TasksRemoteDataSource
import com.codingcat.task.domain.models.HttpRequestError
import com.codingcat.task.domain.models.Task
import com.codingcat.task.domain.repositories.TaskRepository

class TaskRepositoryImpl(
    private val localDataSource: TasksDao,
    private val remoteDataSource: TasksRemoteDataSource
) : TaskRepository {

    override suspend fun getAllTasks(): Either<HttpRequestError, List<Task>> {
        var result: Either<HttpRequestError, List<Task>> =
            either { localDataSource.getAllTasks().map { it.map() } }

        if (result.getOrNull().isNullOrEmpty()) {
            val response = remoteDataSource.getAllTasks()
            result = response.map { data -> data.map { it.map() } }
        }

        return result
    }

    override suspend fun addNewTask(task: Task): Either<HttpRequestError, Unit> {
        val response = remoteDataSource.addNewTask(task.mapToRemote())

        if (response.isRight()) {
            localDataSource.insertTask(task.mapToLocal())
        }

        return response
    }

    override suspend fun deleteTask(task: Task): Either<HttpRequestError, Unit> {
        val response = remoteDataSource.deleteTaskById(task.id)

        if (response.isRight()) {
            localDataSource.deleteTask(task.mapToLocal())
        }

        return response
    }

    override suspend fun updateTask(task: Task): Either<HttpRequestError, Unit> {
        val response = remoteDataSource.updateTaskById(task.id, task.mapToRemote())

        if (response.isRight()) {
            localDataSource.insertTask(task.mapToLocal())
        }

        return response
    }
}