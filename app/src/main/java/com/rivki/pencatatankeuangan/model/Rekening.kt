package com.rivki.pencatatankeuangan.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "rekening")
data class Rekening(
    @PrimaryKey(autoGenerate = true)
    var rekeningID: Int? = 0,
    var namaBank: String?,
    var nomorRekening: String?,
    var atasNama: String?
) : Parcelable