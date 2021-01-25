package com.rivki.pencatatankeuangan.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    protected val errorResponse = MutableLiveData<ErrorResponse>()
    protected val isLoading = MutableLiveData<Boolean>()
    protected val isFetching = MutableLiveData<Boolean>()
    protected val isEmptyData = MutableLiveData<Boolean>()

    fun observeFetching(): LiveData<Boolean> = isFetching
    fun observeError(): LiveData<ErrorResponse> = errorResponse
    fun observeLoading() : LiveData<Boolean> = isLoading
}