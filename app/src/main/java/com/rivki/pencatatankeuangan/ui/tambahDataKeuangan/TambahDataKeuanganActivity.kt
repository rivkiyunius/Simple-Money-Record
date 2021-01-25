package com.rivki.pencatatankeuangan.ui.tambahDataKeuangan

import android.app.Activity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.observe
import com.rivki.pencatatankeuangan.R
import com.rivki.pencatatankeuangan.base.BaseActivity
import com.rivki.pencatatankeuangan.model.UangMasuk
import kotlinx.android.synthetic.main.activity_add_money.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TambahDataKeuanganActivity : BaseActivity() {
    private val viewModel by viewModel<TambahDataKeuanganViewModel>()
    private lateinit var getContent: ActivityResultLauncher<Boolean>
    private lateinit var terimaDari: String
    private lateinit var keterangan: String
    private lateinit var jumlah: String

    override fun onSetuplayout(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_add_money)
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        btn_simpan.setOnClickListener {
            terimaDari = et_terima.text.toString()
            keterangan = et_keterangan.text.toString()
            jumlah = et_jumlah.text.toString()
            val data = UangMasuk(terimaDari = terimaDari, keterangan = keterangan, jumlah = jumlah.toInt())
            viewModel.postDataUangMasuk(data)
            finish()
        }
    }

    override fun observeData() {
        viewModel.inserData.observe(this){

        }
    }
}