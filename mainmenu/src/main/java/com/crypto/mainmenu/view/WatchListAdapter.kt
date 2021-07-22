package com.crypto.mainmenu.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crypto.mainmenu.databinding.ItemWatchlistBinding
import com.crypto.mainmenu.network.entity.Data

class WatchListAdapter() : RecyclerView.Adapter<WatchListAdapter.ViewHolder>() {

    var items = listOf<Data>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListAdapter.ViewHolder {
        val itemBinding = ItemWatchlistBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WatchListAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemWatchlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                name.text = data.coinInfo.name
                companyName.text = data.coinInfo.fullName
                if (data.dISPLAY!=null) {
                    value.text = data.dISPLAY.uSD?.pRICE
                    rate.text = "${data.dISPLAY.uSD?.cHANGEDAY}(${data.dISPLAY.uSD?.cHANGEPCTDAY})"
                }
            }
        }
    }
}