package com.rivki.pencatatankeuangan.module.room

import androidx.room.Room
import com.rivki.pencatatankeuangan.di.BaseModule
import com.rivki.pencatatankeuangan.repository.local.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

object RoomModules: BaseModule {
    override val modules: List<Module>
        get() = listOf(roomModule)

    private val roomModule = module {
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "nutapos-test")
                .addMigrations(RoomMigration.MIGRATION_1_2, RoomMigration.MIGRATION_2_3)
                .build()
        }
        single {get<AppDatabase>().uangMasukDao()}
        single {get<AppDatabase>().rekeningDao()}
    }
}