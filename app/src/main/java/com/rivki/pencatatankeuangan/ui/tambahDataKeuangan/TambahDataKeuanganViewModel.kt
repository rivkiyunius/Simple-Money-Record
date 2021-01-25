package com.rivki.pencatatankeuangan.ui.tambahDataKeuangan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rivki.pencatatankeuangan.base.BaseViewModel
import com.rivki.pencatatankeuangan.base.ResourceState
import com.rivki.pencatatankeuangan.model.UangMasuk
import com.rivki.pencatatankeuangan.repository.DataRepository
import kotlinx.coroutines.launch

class TambahDataKeuanganViewModel(private val dataRepository: DataRepository): BaseViewModel() {
    private val _insertData = MutableLiveData<UangMasuk>()
    val inserData: LiveData<UangMasuk> get() = _insertData

    fun postDataUangMasuk(uangMasuk: UangMasuk){
        viewModelScope.launch {
            when(val request = dataRepository.insertDataUangMasuk(uangMasuk)){
                is ResourceState.Success -> {
                    Log.d("TAG","DATA MASUK!")
                }
                is ResourceState.Error -> {
                    Log.e("TAG_ERROR", request.error.toString())
                }
            }
        }
    }
}