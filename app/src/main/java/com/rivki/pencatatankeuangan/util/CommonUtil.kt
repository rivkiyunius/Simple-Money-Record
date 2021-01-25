package com.rivki.pencatatankeuangan.util

import android.content.Context
import android.widget.Toast

internal fun String.toast(context: Context){
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}