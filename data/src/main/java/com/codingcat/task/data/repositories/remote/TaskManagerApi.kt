package com.codingcat.task.data.repositories.remote

import arrow.core.Either
import com.codingcat.task.data.model.TaskRemoteDto
import com.codingcat.task.domain.models.HttpRequestError
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.PUT
import retrofit2.http.Path

interface TaskManagerApi {
    @GET("tasks.json")
    suspend fun getAllTasks(): Either<HttpRequestError, List<TaskRemoteDto>>

    @PUT("tasks.json")
    suspend fun addNewTask(@Body newTask: TaskRemoteDto): Either<HttpRequestError, Unit>

    @DELETE("tasks/{id}.json")
    suspend fun deleteTaskById(@Path("id") id: Int): Either<HttpRequestError, Unit>

    @PATCH("tasks/{id}.json")
    suspend fun updateTaskById(
        @Path("id") id: Int,
        @Body updatedTask: TaskRemoteDto
    ): Either<HttpRequestError, Unit>
}