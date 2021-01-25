package com.rivki.pencatatankeuangan.module.viewModel

import com.rivki.pencatatankeuangan.base.DiffCallback
import com.rivki.pencatatankeuangan.di.BaseModule
import com.rivki.pencatatankeuangan.ui.home.HomeViewModel
import com.rivki.pencatatankeuangan.ui.tambahDataKeuangan.TambahDataKeuanganViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModules: BaseModule {
    override val modules: List<Module>
        get() = listOf(viewModelModule)

    private val viewModelModule = module{
        viewModel { HomeViewModel(get()) }
        viewModel { TambahDataKeuanganViewModel(get(), get()) }
        factory { DiffCallback() }
    }

}