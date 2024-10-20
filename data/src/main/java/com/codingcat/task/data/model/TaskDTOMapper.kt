package com.codingcat.task.data.model

import com.codingcat.task.domain.models.Task

object TaskDTOMapper {
    fun TaskLocal.map() = Task(
        id = id,
        title = title ?: "",
        description = description ?: "",
        category = category ?: "",
        date = date ?: "",
        startTime = startTime ?: "",
        endTime = endTime ?: "",
    )

    fun TaskRemote.map() = Task(
        id = id,
        title = title,
        description = description,
        category = category,
        date = date,
        startTime = startTime,
        endTime = endTime,
    )

    fun Task.mapToLocal() = TaskLocal(
        id = id,
        title = title,
        description = description,
        category = category,
        date = date,
        startTime = startTime,
        endTime = endTime,
    )

    fun Task.mapToRemote() = TaskRemote(
        id = id,
        title = title,
        description = description,
        category = category,
        date = date,
        startTime = startTime,
        endTime = endTime,
    )
}