package com.codingcat.task.data.repositories.remote

import com.codingcat.task.data.model.TaskRemote
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.PUT

interface TaskManagerApi {
    @GET("tasks.json")
    suspend fun getAllTasks(): Response<List<TaskRemote>>

    @PUT("tasks.json")
    suspend fun addNewTask(@Body newTask: TaskRemote): Response<Any>

    @DELETE("tasks/{id}.json")
    suspend fun deleteTaskById(id: Int): Response<Any>

    @PATCH("tasks/{id}.json")
    suspend fun updateTaskById(id: Int, updatedTask: TaskRemote): Response<Any>
}