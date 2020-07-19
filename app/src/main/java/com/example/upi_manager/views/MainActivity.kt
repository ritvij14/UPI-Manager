 package com.example.upi_manager.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upi_manager.DatabaseInterface
import com.example.upi_manager.R
import com.example.upi_manager.adapters.RecyclerAdapter
import com.example.upi_manager.models.TransactionModel
import com.example.upi_manager.utilities.toast
import com.example.upi_manager.viewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

     private lateinit var list: ArrayList<TransactionModel>
     private lateinit var mMainActivityViewModel: MainActivityViewModel
     private lateinit var adapter: RecyclerAdapter

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

         val dbInterface = object : DatabaseInterface {
             override fun onRetrieveStart() {
                 progress_bar.visibility = View.VISIBLE
             }

             override fun onRetrieveSuccess() {
                 progress_bar.visibility = View.GONE
                 mMainActivityViewModel.getTestTransaction()
                     .observe(this@MainActivity, Observer<ArrayList<TransactionModel>> { t ->
                         adapter = RecyclerAdapter(t)
                         adapter.notifyDataSetChanged()
                         initRecyclerView()
                         toast("done")
                     })
             }

             override fun onRetrieveFailed() {
                 Log.d("DATABASE", "Unable to retrieve")
             }
         }
         mMainActivityViewModel.init(dbInterface)
     }

     private fun initRecyclerView() {
         val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
         upi_recycler_view.layoutManager = linearLayoutManager
         upi_recycler_view.adapter = adapter
     }
 }