package com.rivki.pencatatankeuangan.module.data

import com.rivki.pencatatankeuangan.di.BaseModule
import com.rivki.pencatatankeuangan.repository.DataRepository
import com.rivki.pencatatankeuangan.repository.local.LocalDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

object DataModules: BaseModule {
    override val modules: List<Module>
        get() = listOf(dataModule)

    private val dataModule = module {
        single {LocalDataSource(get(), get())}
        single {DataRepository(get())}
    }

}