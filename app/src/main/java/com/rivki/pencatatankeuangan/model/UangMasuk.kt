package com.rivki.pencatatankeuangan.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "uang_masuk")
data class UangMasuk(
    @PrimaryKey(autoGenerate = true)
    var uangMasuId: Int = 0,
    var terimaDari: String?,
    var keterangan: String?,
    var jumlah: Int,
    var tanggal: String?,
    var nomor: String?,
    var rekeningID: Int? = 0
) : Parcelable