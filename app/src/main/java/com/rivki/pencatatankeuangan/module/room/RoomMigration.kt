package com.rivki.pencatatankeuangan.module.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object RoomMigration {
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE uang_masuk ADD COLUMN tanggal TEXT")
            database.execSQL("ALTER TABLE uang_masuk ADD COLUMN nomor TEXT")
        }
    }
}