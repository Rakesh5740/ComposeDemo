package com.composedemo.network

/**
 * Will be thrown if there is any error during the request (will mostly be mapping failures).
 */
class MappingException(throwable: Throwable) : Exception(throwable.message ?: "Unknown error cause", throwable)

/**
 * Will be thrown if the response of a network request is not supported.
 * Most of the time this is everything besides a successful 200 response.
 *
 * @param statusCode the response status code of the api response
 */
class ApiException(statusCode: Int) : Exception(getMessage(statusCode)) {

    private companion object {

        private fun getMessage(code: Int) = when (code) {
            401, 403 -> "Access unauthorized or forbidden with status code $code"
            else -> "Error with status code $code."
        }
    }
}
