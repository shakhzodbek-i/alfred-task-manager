package com.codingcat.task.data.repositories.local

import androidx.room.Database
import com.codingcat.task.data.model.TaskLocalDto

@Database(entities = [TaskLocalDto::class], version = 1)
abstract class TasksDatabase {
    abstract fun tasksDao(): TaskDao
}