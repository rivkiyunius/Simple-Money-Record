package com.rivki.pencatatankeuangan.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rivki.pencatatankeuangan.model.UangMasuk

@Dao
interface UangMasukDao {
    @Query("SELECT * FROM uang_masuk")
    suspend fun getAll(): MutableList<UangMasuk>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(vararg uangMasuk: UangMasuk)
}