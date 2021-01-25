package com.rivki.pencatatankeuangan.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rivki.pencatatankeuangan.R
import com.rivki.pencatatankeuangan.base.DiffCallback
import com.rivki.pencatatankeuangan.model.UangMasuk
import kotlinx.android.synthetic.main.item_view_home.view.*

class HomeAdapter(private val diffCallback: DiffCallback = DiffCallback()): RecyclerView.Adapter<HomeAdapter.HomeAdapterVH>() {
    private val listData = mutableListOf<UangMasuk>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_home, parent, false)
        return HomeAdapterVH(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: HomeAdapterVH, position: Int) {
        holder.bindData(listData[position])
    }

    fun setListUserData(data: List<UangMasuk>){
        calculateDiff(data)
    }

    private fun calculateDiff(newData: List<UangMasuk>){
        diffCallback.setList(listData, newData)
        val result = DiffUtil.calculateDiff(diffCallback)
        with(listData){
            clear()
            addAll(newData)
        }
        result.dispatchUpdatesTo(this)
    }

    inner class HomeAdapterVH(private val view: View): RecyclerView.ViewHolder(view) {
        fun bindData(uangMasuk: UangMasuk){
            with(view){
                tv_terima_dari.text = uangMasuk.terimaDari
                tv_keterangan.text = uangMasuk.keterangan
                tv_jumlah.text = uangMasuk.jumlah.toString()
            }
        }
    }
}