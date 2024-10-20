package com.codingcat.task.domain.models

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val date: String,
    val startTime: String,
    val endTime: String,
)
