package com.rivki.pencatatankeuangan.util

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

internal fun String.toast(context: Context){
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

internal fun formatDate(format: String): String {
    val df = SimpleDateFormat(format)
    return df.format(Calendar.getInstance().time)
}