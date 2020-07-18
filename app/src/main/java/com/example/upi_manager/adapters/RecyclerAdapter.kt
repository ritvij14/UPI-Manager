package com.example.upi_manager.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.upi_manager.R
import com.example.upi_manager.models.TransactionModel
import kotlinx.android.synthetic.main.listitem.view.*

class RecyclerAdapter (private val recyclerList: ArrayList<TransactionModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val test: TextView = itemView.findViewById(R.id.card_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return recyclerList.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item: TransactionModel = recyclerList[position]
        holder?.test.text = "test"
    }
}