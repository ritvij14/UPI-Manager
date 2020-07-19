package com.example.upi_manager.repositories

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.upi_manager.models.TransactionModel
import com.example.upi_manager.views.MainActivity
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class MainActivityRepository {

    private lateinit var list: ArrayList<TransactionModel>
    private var dbRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("Transactions")

    fun getTransactions(): MutableLiveData<ArrayList<TransactionModel>> {
        setTransactions()

        val data: MutableLiveData<ArrayList<TransactionModel>> = MutableLiveData()
        data.postValue(list)
        return data
    }

    private fun setTransactions() {

        list = ArrayList()
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                Log.d("DATABASE", "Unable to retrieve")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                Log.d("ON_DATA_CHANGE", "Reached on data change")
                //list.add(TransactionModel(children.toInt(), "Debit", "Payment to Shop"))
                for (child in children) {
                    val item: TransactionModel = child.getValue<TransactionModel>()!!
                    list.add(item)
                }
            }
        })

        list.add(TransactionModel(list.size, "Debit", "Payment to Shop"))
    }

    companion object {
        private var instance: MainActivityRepository? = null
        fun getInstance() = instance
            ?: MainActivityRepository().also {
                instance = it
            }
    }
}