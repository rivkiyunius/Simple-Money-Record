package com.rivki.pencatatankeuangan.model.sharedPreferences

import android.content.SharedPreferences
import androidx.core.content.edit

class AppPreferencesHelper(private val sharedPreferences: SharedPreferences) {
    fun saveCurrentCounter(counter: Int) {
        sharedPreferences.edit { putInt("counter", counter) }
    }
    fun getCurrentCounter(): Int? = sharedPreferences.getInt("counter", 0)
}