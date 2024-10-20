package com.codingcat.task.data.repositories.remote

import com.codingcat.task.data.model.TaskRemote
import com.codingcat.task.data.repositories.remote.Utils.handleResponse

class RemoteDataSource(private val api: TaskManagerApi) {
    suspend fun getAllTasks() = api.getAllTasks().handleResponse()

    suspend fun addNewTask(newTask: TaskRemote) =
        api.addNewTask(newTask).handleResponse()

    suspend fun deleteTaskById(id: Int) = api.deleteTaskById(id).handleResponse()

    suspend fun updateTaskById(id: Int, updatedTask: TaskRemote) =
        api.updateTaskById(id, updatedTask).handleResponse()
}