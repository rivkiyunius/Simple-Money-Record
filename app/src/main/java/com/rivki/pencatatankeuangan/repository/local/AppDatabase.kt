package com.rivki.pencatatankeuangan.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rivki.pencatatankeuangan.model.UangMasuk
import com.rivki.pencatatankeuangan.model.db.UangMasukDao

@Database(entities = [UangMasuk::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun uangMasukDao(): UangMasukDao
}