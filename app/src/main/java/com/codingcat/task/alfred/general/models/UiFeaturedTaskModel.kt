package com.codingcat.task.alfred.general.models

import androidx.annotation.DrawableRes

data class UiFeaturedTaskModel(
    @DrawableRes
    val iconRes: Int,
    val taskData: UiTaskModel
)
