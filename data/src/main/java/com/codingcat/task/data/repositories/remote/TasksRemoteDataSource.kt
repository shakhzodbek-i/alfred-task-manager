package com.codingcat.task.data.repositories.remote

import com.codingcat.task.data.model.TaskRemoteDto

class TasksRemoteDataSource(private val api: TaskManagerApi) {
    suspend fun getAllTasks() = api.getAllTasks()

    suspend fun addNewTask(newTask: TaskRemoteDto) = api.addNewTask(newTask)

    suspend fun deleteTaskById(id: Int) = api.deleteTaskById(id)

    suspend fun updateTaskById(id: Int, updatedTask: TaskRemoteDto) =
        api.updateTaskById(id, updatedTask)
}