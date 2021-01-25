package com.rivki.pencatatankeuangan.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rivki.pencatatankeuangan.base.BaseViewModel
import com.rivki.pencatatankeuangan.base.ResourceState
import com.rivki.pencatatankeuangan.model.UangMasuk
import com.rivki.pencatatankeuangan.repository.DataRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val dataRepository: DataRepository) : BaseViewModel() {
    private val _homeData = MutableLiveData<List<UangMasuk>>()
    val homeData : LiveData<List<UangMasuk>> get() = _homeData

    fun getDataHome(){
        viewModelScope.launch {
            when(val request = dataRepository.getAllData()){
                is ResourceState.Success -> {
                    _homeData.postValue(request.result.data!!)
                }
                is ResourceState.Error -> {
                    Log.e("TAG_ERROR", request.error.toString())
                }
            }
        }
    }
}