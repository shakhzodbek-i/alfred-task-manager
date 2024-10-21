package com.codingcat.task.domain.repositories

import arrow.core.Either
import com.codingcat.task.domain.models.HttpRequestError
import com.codingcat.task.domain.models.Task

interface TaskRepository {

    suspend fun getAllTasks(): Either<HttpRequestError, List<Task>>

    suspend fun addNewTask(task: Task): Either<HttpRequestError, Unit>

    suspend fun deleteTask(task: Task): Either<HttpRequestError, Unit>

    suspend fun updateTask(task: Task): Either<HttpRequestError, Unit>
}