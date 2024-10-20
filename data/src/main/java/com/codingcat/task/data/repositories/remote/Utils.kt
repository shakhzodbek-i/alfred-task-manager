package com.codingcat.task.data.repositories.remote

import com.codingcat.task.data.model.Error
import com.codingcat.task.data.model.Success
import retrofit2.Response

object Utils {
    fun <T> Response<T>.handleResponse() =
        if (this.isSuccessful) {
            Success(this.body())
        } else {
            Error(this.code(), this.message())
        }
}