package com.codingcat.task.data.repositories.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.codingcat.task.data.model.TaskLocal

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<TaskLocal>

    @Upsert
    suspend fun insertTask(task: TaskLocal)

    @Delete
    suspend fun deleteTask(task: TaskLocal)
}