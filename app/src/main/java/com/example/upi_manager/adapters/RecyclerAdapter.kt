package com.example.upi_manager.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upi_manager.R
import com.example.upi_manager.models.TransactionModel

class RecyclerAdapter (private val recyclerList: ArrayList<TransactionModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var amount: TextView = itemView.findViewById(R.id.card_tv_amount)
        var type: TextView = itemView.findViewById(R.id.card_tv_type)
        var info: TextView = itemView.findViewById(R.id.card_tv_info)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return recyclerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: TransactionModel = recyclerList[position]
        holder.amount.text = item.amount.toString()
        holder.info.text = item.info
        holder.type.text = item.type
    }
}