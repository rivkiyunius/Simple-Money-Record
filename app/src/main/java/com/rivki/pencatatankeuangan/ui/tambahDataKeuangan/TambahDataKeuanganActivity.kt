package com.rivki.pencatatankeuangan.ui.tambahDataKeuangan

import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.observe
import com.rivki.pencatatankeuangan.R
import com.rivki.pencatatankeuangan.base.BaseActivity
import com.rivki.pencatatankeuangan.util.formatDate
import kotlinx.android.synthetic.main.activity_add_money.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class TambahDataKeuanganActivity : BaseActivity() {
    private val viewModel by viewModel<TambahDataKeuanganViewModel>()
    private lateinit var terimaDari: String
    private lateinit var keterangan: String
    private lateinit var jumlah: String

    override fun onSetuplayout(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_add_money)
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        val currentDate = Calendar.getInstance().time
        var getCurrentCounter = 0
        btn_simpan.setOnClickListener {
            terimaDari = et_terima.text.toString()
            keterangan = et_keterangan.text.toString()
            jumlah = et_jumlah.text.toString()
            viewModel.let {
                getCurrentCounter = it.getCurrentCounter()!!
                val nomor = "UM/${formatDate("yyMMdd")}/${++getCurrentCounter}"
                it.postDataUangMasuk(terimaDari, keterangan, jumlah.toInt(), currentDate.toString(), nomor)
                it.saveCurrentNumber(getCurrentCounter)
            }
            finish()
        }
    }

    override fun observeData() {
        viewModel.inserData.observe(this) {

        }
    }
}