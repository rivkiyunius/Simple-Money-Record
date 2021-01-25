package com.rivki.pencatatankeuangan.ui.tambahDataKeuangan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rivki.pencatatankeuangan.base.BaseViewModel
import com.rivki.pencatatankeuangan.base.ResourceState
import com.rivki.pencatatankeuangan.model.UangMasuk
import com.rivki.pencatatankeuangan.model.sharedPreferences.AppPreferencesHelper
import com.rivki.pencatatankeuangan.repository.DataRepository
import kotlinx.coroutines.launch

class TambahDataKeuanganViewModel(private val dataRepository: DataRepository, private val preferences: AppPreferencesHelper) : BaseViewModel() {
    private val _insertData = MutableLiveData<UangMasuk>()
    val inserData: LiveData<UangMasuk> get() = _insertData

    fun postDataUangMasuk(terimaDari: String, keterangan: String, jumlah: Int, tanggal: String, nomor: String) {
        val data = UangMasuk(
            terimaDari = terimaDari,
            keterangan = keterangan,
            jumlah = jumlah,
            tanggal = tanggal,
            nomor = nomor
        )
        viewModelScope.launch {
            when (val request = dataRepository.insertDataUangMasuk(data)) {
                is ResourceState.Success -> {
                    Log.d("TAG", "DATA MASUK!")
                }
                is ResourceState.Error -> {
                    Log.e("TAG_ERROR", request.error.toString())
                }
            }
        }
    }

    fun saveCurrentNumber(currentNumber: Int){
        preferences.saveCurrentCounter(currentNumber)
    }
    fun getCurrentCounter(): Int? = preferences.getCurrentCounter()
}