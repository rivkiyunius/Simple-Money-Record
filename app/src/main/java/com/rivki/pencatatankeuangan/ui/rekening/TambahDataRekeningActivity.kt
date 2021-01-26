package com.rivki.pencatatankeuangan.ui.rekening

import android.os.Bundle
import androidx.lifecycle.observe
import com.rivki.pencatatankeuangan.R
import com.rivki.pencatatankeuangan.base.BaseActivity
import kotlinx.android.synthetic.main.activity_tambah_data_rekening.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TambahDataRekeningActivity : BaseActivity() {
    private val rekeningViewModel by viewModel<TambahDataRekeningViewModel>()
    private lateinit var namaBank: String
    private lateinit var noRekening: String
    private lateinit var atasNama: String

    override fun onSetuplayout(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_tambah_data_rekening)
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        btn_simpan.setOnClickListener {
            namaBank = et_nama_bank.text.toString()
            noRekening = et_no_rekening.text.toString()
            atasNama = et_atas_nama.text.toString()
            rekeningViewModel.postDataRekening(namaBank, noRekening, atasNama)
            finish()
        }
    }

    override fun observeData() {
        rekeningViewModel.insertRekening.observe(this){

        }
    }
}