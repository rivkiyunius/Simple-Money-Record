package com.rivki.pencatatankeuangan.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetuplayout(savedInstanceState)
        onViewReady(savedInstanceState)
        observeData()
    }
    abstract fun onSetuplayout(savedInstanceState: Bundle?)
    abstract fun onViewReady(savedInstanceState: Bundle?)
    abstract fun observeData()
}