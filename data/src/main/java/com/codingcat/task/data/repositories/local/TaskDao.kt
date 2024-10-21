package com.codingcat.task.data.repositories.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.codingcat.task.data.model.TaskLocalDto

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<TaskLocalDto>

    @Upsert
    suspend fun insertTask(task: TaskLocalDto)

    @Delete
    suspend fun deleteTask(task: TaskLocalDto)
}