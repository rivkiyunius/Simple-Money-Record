package com.rivki.pencatatankeuangan.module.sharedPreferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.rivki.pencatatankeuangan.di.BaseModule
import com.rivki.pencatatankeuangan.model.sharedPreferences.AppPreferencesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

object SharedPreferences : BaseModule {
    override val modules: List<Module>
        get() = listOf(
            sharedPreferenceModule
        )

    private val sharedPreferenceModule = module {
        single { provideSettingsPreferences(androidApplication()) }
        single { AppPreferencesHelper(get()) }
    }
    private const val PREFERENCES_FILE_KEY = "com.rivki.moneyrecord.preferences"
    private fun provideSettingsPreferences(app: Application): SharedPreferences? =
        app.getSharedPreferences(
            PREFERENCES_FILE_KEY, Context.MODE_PRIVATE
        )

}