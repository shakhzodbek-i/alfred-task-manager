package com.codingcat.task.domain.models

sealed class HttpRequestError {
    data object Generic : HttpRequestError()
    data object NetworkError : HttpRequestError()
    data object NotFound : HttpRequestError()
}