package com.codingcat.task.data.model

sealed class Result<out T: Any>
class Error(val errorCode: Int, val errorMessage: String): Result<Nothing>()
class Success<out T: Any>(val data: T?): Result<T>()