package com.rivki.pencatatankeuangan.repository

import com.rivki.pencatatankeuangan.model.UangMasuk
import com.rivki.pencatatankeuangan.repository.local.LocalDataSource

class DataRepository(private val localDataSource: LocalDataSource) {
    suspend fun getAllData() = localDataSource.getAllData()
    suspend fun insertDataUangMasuk(uangMasuk: UangMasuk) = localDataSource.insertUangMasuk(uangMasuk)
}