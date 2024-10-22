package com.codingcat.task.data.repositories.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.codingcat.task.data.model.TaskLocalDto
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class TaskDaoTest {

    /**
     * Because the database manipulations normally are executed in background executor (Thread),
     * so this Rule swaps this executor with one which executes each task synchronously.
     *
     * You can use this rule for your host side tests that use Architecture Components.
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: TasksDatabase
    private lateinit var dao: TaskDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TasksDatabase::class.java
            /**
             * allowMainThreadQueries() was used there because all test cases should be run
             * on only one thread. If it will be multithreading used here, then we might have different
             * outcome from different test cases.
             */
        ).allowMainThreadQueries().build()

        dao = database.tasksDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertTask() = runTest {
        val task = TaskLocalDto(
            id = 1,
            title = "Create app icon with AI",
            description = "Some Long Description of the task for testing. It looks good. Let's go!",
            category = "Design",
            date = "Oct 30, 2024",
            startTime = "12:30",
            endTime = "13:30"
        )

        dao.insertTask(task)

        val allTasks = dao.getAllTasks()

        assertThat(allTasks).contains(task)
    }

    @Test
    fun deleteTask() = runTest {
        val task = TaskLocalDto(
            id = 1,
            title = "Create app icon with AI",
            description = "Some Long Description of the task for testing. It looks good. Let's go!",
            category = "Design",
            date = "Oct 30, 2024",
            startTime = "12:30",
            endTime = "13:30"
        )

        dao.insertTask(task)
        dao.deleteTask(task)

        val allTasks = dao.getAllTasks()

        assertThat(allTasks).doesNotContain(task)
    }

}