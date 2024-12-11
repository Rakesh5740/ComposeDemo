package com.composedemo.network

sealed class ApiState<out T> {

    data object Loading : ApiState<Nothing>()
    data class Success<out T>(val data: T) : ApiState<T>()
    data class Error(val failureType: FailureType) : ApiState<Nothing>()

}

enum class FailureType {
    FATAL,
    RETRY,
    FORBIDDEN
}
