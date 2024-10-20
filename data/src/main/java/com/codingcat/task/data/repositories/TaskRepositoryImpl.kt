package com.codingcat.task.data.repositories

import com.codingcat.task.data.model.Error
import com.codingcat.task.data.model.HttpError
import com.codingcat.task.data.model.Success
import com.codingcat.task.data.model.TaskDTOMapper.map
import com.codingcat.task.data.model.TaskDTOMapper.mapToLocal
import com.codingcat.task.data.model.TaskDTOMapper.mapToRemote
import com.codingcat.task.data.model.TaskRemote
import com.codingcat.task.data.repositories.local.TaskDao
import com.codingcat.task.data.repositories.remote.RemoteDataSource
import com.codingcat.task.domain.models.Task
import com.codingcat.task.domain.repositories.TaskRepository

class TaskRepositoryImpl(
    private val localDataSource: TaskDao,
    private val remoteDataSource: RemoteDataSource
) : TaskRepository {

    override suspend fun getAllTasks(): List<Task> {
        var result = localDataSource.getAllTasks().map { it.map() }

        if (result.isEmpty()) {
            when (val response = remoteDataSource.getAllTasks()) {
                is Success<List<TaskRemote>> -> {
                    result = response.data?.map { it.map() } ?: emptyList()
                }

                is Error -> {
                    throw HttpError(response.errorCode, response.errorMessage)
                }
            }
        }

        return result
    }

    override suspend fun addNewTask(task: Task) {
        when (val response = remoteDataSource.addNewTask(task.mapToRemote())) {
            is Success<Any> -> {
                localDataSource.insertTask(task.mapToLocal())
            }

            is Error -> {
                throw HttpError(response.errorCode, response.errorMessage)
            }
        }
    }

    override suspend fun deleteTask(task: Task) {
        when (val response = remoteDataSource.deleteTaskById(task.id)) {
            is Success<Any> -> {
                localDataSource.deleteTask(task.mapToLocal())
            }

            is Error -> {
                throw HttpError(response.errorCode, response.errorMessage)
            }
        }
    }

    override suspend fun updateTask(task: Task) {
        when (val response = remoteDataSource.updateTaskById(task.id, task.mapToRemote())) {
            is Success<Any> -> {
                localDataSource.insertTask(task.mapToLocal())
            }

            is Error -> {
                throw HttpError(response.errorCode, response.errorMessage)
            }
        }
    }
}