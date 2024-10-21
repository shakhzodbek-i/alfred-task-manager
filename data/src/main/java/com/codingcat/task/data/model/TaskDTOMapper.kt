package com.codingcat.task.data.model

import com.codingcat.task.domain.models.Task

object TaskDTOMapper {
    fun TaskLocalDto.map() = Task(
        id = id,
        title = title ?: "",
        description = description ?: "",
        category = category ?: "",
        date = date ?: "",
        startTime = startTime ?: "",
        endTime = endTime ?: "",
    )

    fun TaskRemoteDto.map() = Task(
        id = id,
        title = title,
        description = description,
        category = category,
        date = date,
        startTime = startTime,
        endTime = endTime,
    )

    fun Task.mapToLocal() = TaskLocalDto(
        id = id,
        title = title,
        description = description,
        category = category,
        date = date,
        startTime = startTime,
        endTime = endTime,
    )

    fun Task.mapToRemote() = TaskRemoteDto(
        id = id,
        title = title,
        description = description,
        category = category,
        date = date,
        startTime = startTime,
        endTime = endTime,
    )
}