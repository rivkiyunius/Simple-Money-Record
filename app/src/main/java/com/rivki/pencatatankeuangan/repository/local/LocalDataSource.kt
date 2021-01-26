package com.rivki.pencatatankeuangan.repository.local

import com.rivki.pencatatankeuangan.base.BaseDataSource
import com.rivki.pencatatankeuangan.base.ResourceState
import com.rivki.pencatatankeuangan.base.ResponseWrapper
import com.rivki.pencatatankeuangan.model.Rekening
import com.rivki.pencatatankeuangan.model.UangMasuk
import com.rivki.pencatatankeuangan.model.db.RekeningDao
import com.rivki.pencatatankeuangan.model.db.UangMasukDao
import java.lang.Exception

class LocalDataSource(private val uangMasukDao: UangMasukDao, private val rekeningDao: RekeningDao) : BaseDataSource() {
    private suspend fun <T> getResult(request: suspend () -> T): ResourceState<ResponseWrapper<T>> {
        return try {
            val res = request.invoke()
            return ResourceState.Success(ResponseWrapper(data = res, errorData = null))
        }catch (e: Exception) {
            errorState(message = e.toString())
        }
    }

    suspend fun getAllData() = suspendDataResult {getResult{uangMasukDao.getAll()}}
    suspend fun insertUangMasuk(uangMasuk: UangMasuk) = suspendDataResult {getResult{uangMasukDao.insertData(uangMasuk)}}
    suspend fun getDataRekening() = suspendDataResult{getResult{rekeningDao.getAll()}}
    suspend fun insertDataRekening(rekening: Rekening) = suspendDataResult{getResult{rekeningDao.insertData(rekening)}}
}