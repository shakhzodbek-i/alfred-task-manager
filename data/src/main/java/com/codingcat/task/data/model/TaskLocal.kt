package com.codingcat.task.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "tasks"
)
data class TaskLocal(
    @PrimaryKey
    val id: Int,
    @ColumnInfo("title")
    val title: String?,
    @ColumnInfo("description")
    val description: String?,
    @ColumnInfo("category")
    val category: String?,
    @ColumnInfo("date")
    val date: String?,
    @ColumnInfo("startTime")
    val startTime: String?,
    @ColumnInfo("endTime")
    val endTime: String?,
)
