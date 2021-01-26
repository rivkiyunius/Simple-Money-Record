package com.rivki.pencatatankeuangan.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rivki.pencatatankeuangan.model.Rekening

@Dao
interface RekeningDao {
    @Query("SELECT * FROM rekening")
    suspend fun getAll(): MutableList<Rekening>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(vararg rekening: Rekening)
}