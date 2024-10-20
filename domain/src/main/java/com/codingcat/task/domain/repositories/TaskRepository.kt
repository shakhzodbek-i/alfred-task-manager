package com.codingcat.task.domain.repositories

import com.codingcat.task.domain.models.Task

interface TaskRepository {

    suspend fun getAllTasks(): List<Task>

    suspend fun addNewTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun updateTask(task: Task)
}