package com.rivki.pencatatankeuangan.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivki.pencatatankeuangan.R
import com.rivki.pencatatankeuangan.base.BaseActivity
import com.rivki.pencatatankeuangan.base.DiffCallback
import com.rivki.pencatatankeuangan.model.UangMasuk
import com.rivki.pencatatankeuangan.ui.tambahDataKeuangan.TambahDataKeuanganActivity
import com.rivki.pencatatankeuangan.util.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val homeViewModel by viewModel<HomeViewModel>()
    private val diffCallback by inject<DiffCallback>()
    private val homeAdapter by lazy {
        HomeAdapter(diffCallback)
    }

    override fun onSetuplayout(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getDataHome()
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        with(rv_main){
            layoutManager = LinearLayoutManager(this@MainActivity)
            val dividerItemDecoration = DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
            adapter = homeAdapter
            addItemDecoration(dividerItemDecoration)
        }
        fab_main.setOnClickListener {
            val intent = Intent(this@MainActivity, TambahDataKeuanganActivity::class.java)
            startActivity(intent)
        }
    }

    override fun observeData() {
        homeViewModel.let {viewModel ->
            viewModel.getDataHome()
            viewModel.homeData.observe(this){
                homeAdapter.setListUserData(it)
            }
        }
    }
}