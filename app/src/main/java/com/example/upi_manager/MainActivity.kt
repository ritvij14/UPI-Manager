 package com.example.upi_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upi_manager.adapters.RecyclerAdapter
import com.example.upi_manager.models.TransactionModel
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

     public val TAG: String = "MAIN_ACTIVITY"
     private lateinit var list: ArrayList<TransactionModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

     private fun initRecyclerView() {

         val item: TransactionModel = TransactionModel("test")
         val item2: TransactionModel = TransactionModel("test2")
         list.add(item)
         list.add(item2)
         val adapter: RecyclerAdapter = RecyclerAdapter(list)
         val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
         upi_recycler_view.layoutManager = linearLayoutManager
         upi_recycler_view.adapter = adapter
     }

     private fun showProgressBar() { progress_bar.visibility = View.VISIBLE }

     private fun hideProgressBar() { progress_bar.visibility = View.GONE }
 }