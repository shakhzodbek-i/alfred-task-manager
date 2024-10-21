package com.codingcat.task.domain.usecases

import arrow.core.Either
import com.codingcat.task.domain.models.HttpRequestError
import com.codingcat.task.domain.models.Task
import com.codingcat.task.domain.repositories.TaskRepository

class AddTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task): Either<HttpRequestError, Unit> =
        taskRepository.addNewTask(task)
}