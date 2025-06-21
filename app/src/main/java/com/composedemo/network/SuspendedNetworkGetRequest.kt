package com.composedemo.network

import androidx.annotation.Discouraged
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException


/**
 * Can be used for: hot, GET, using suspend.
 */
suspend inline fun <ResultType, ResponseType> suspendedNetworkGetRequest(
    crossinline fetch: suspend () -> Response<ResponseType>,
    crossinline getBody: (response: Response<ResponseType>) -> ResponseType = { it.body()!! },
    crossinline map: suspend (ResponseType) -> ResultType,
    crossinline onSuccess: suspend (ResultType) -> Unit,
    crossinline onMappingFailure: (MappingException) -> Unit = { },
    noinline onApiFailure: (responseCode: Int) -> Unit = { },
    crossinline onCancellation: (causeMessage: String?) -> Unit = { },
    validResponseCodes: List<Int> = listOf(200),
    dispatcher: CoroutineDispatcher = Dispatchers.Default
): ApiState<ResultType> = withContext(dispatcher) {
    try {
        val response = fetch()
        when (val code = response.code()) {
            in validResponseCodes -> {
                val result = map(getBody(response))
                onSuccess(result)
                ApiState.Success(result)
            }
            401, 403 -> {
                // Access unauthorized or forbidden
                onApiFailure(code)
                ApiState.Error(FailureType.FORBIDDEN)
            }
            502, 504 -> {
                // Not calling onApiFailure for gateway errors, so they don't get logged
                ApiState.Error(FailureType.FATAL)
            }
            else -> {
                onApiFailure(code)
                ApiState.Error(FailureType.FATAL)
            }
        }
    } catch (ioException: IOException) {
        // IOException will only propagated to the UI to show retry option
        ApiState.Error(FailureType.RETRY)
    } catch (ce: CancellationException) {
        // Indicates normal cancellation of a coroutine,
        // Thrown by cancellable suspending functions
        // Since suspend functions expects a result, we populate a Retry.
        onCancellation(ce.message)
        ApiState.Error(FailureType.RETRY)
    } catch (exception: Exception) {
        onMappingFailure(MappingException(exception))
        ApiState.Error(FailureType.FATAL)
    }
}