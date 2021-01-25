package com.rivki.pencatatankeuangan.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseDataSource {
    fun <T> errorState(message: String, error: String? = ""): ResourceState<ResponseWrapper<T>> {
        return ResourceState.Error(ResponseWrapper(null, ErrorResponse(error, message)))
    }

    suspend fun <T> suspendDataResult(request: suspend () -> ResourceState<T>): ResourceState<T> {
        return withContext(Dispatchers.IO) {
            request.invoke()
        }
    }
}