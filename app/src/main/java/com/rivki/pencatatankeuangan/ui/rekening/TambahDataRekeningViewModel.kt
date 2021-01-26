package com.rivki.pencatatankeuangan.ui.rekening

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rivki.pencatatankeuangan.base.BaseViewModel
import com.rivki.pencatatankeuangan.base.ResourceState
import com.rivki.pencatatankeuangan.model.Rekening
import com.rivki.pencatatankeuangan.repository.DataRepository
import com.rivki.pencatatankeuangan.repository.local.LocalDataSource
import kotlinx.coroutines.launch

class TambahDataRekeningViewModel(private val dataRepository: DataRepository) : BaseViewModel() {
    private val _insertRekening = MutableLiveData<Rekening>()
    val insertRekening: LiveData<Rekening> get() = _insertRekening

    fun postDataRekening(namaBank: String, noRekening: String, atasNama: String) {
        val data = Rekening(namaBank = namaBank, nomorRekening = noRekening, atasNama = atasNama)
        viewModelScope.launch {
            when(val request = dataRepository.insertDataRekening(data)){
                is ResourceState.Success -> {
                    Log.d("TAG", "DATA MASUK!")
                }
                is ResourceState.Error -> {
                    Log.e("TAG_ERROR", request.error.toString())
                }
            }
        }
    }
}