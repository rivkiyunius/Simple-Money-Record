package com.rivki.pencatatankeuangan.di

import com.rivki.pencatatankeuangan.module.data.DataModules
import com.rivki.pencatatankeuangan.module.room.RoomModules
import com.rivki.pencatatankeuangan.module.viewModel.ViewModelModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DepsModuleProvider {
    val modules: List<Module>
        get() {
            return ArrayList<Module>().apply {
                addAll(ViewModelModules.modules)
                addAll(RoomModules.modules)
                addAll(DataModules.modules)
            }
        }
}