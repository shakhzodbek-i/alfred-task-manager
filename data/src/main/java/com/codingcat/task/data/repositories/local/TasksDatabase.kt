package com.codingcat.task.data.repositories.local

import androidx.room.Database
import com.codingcat.task.data.model.TaskLocal

@Database(entities = [TaskLocal::class], version = 1)
abstract class TasksDatabase {
    abstract fun tasksDao(): TaskDao
}