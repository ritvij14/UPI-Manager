package com.example.upi_manager.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.upi_manager.models.TransactionModel
import com.example.upi_manager.repositories.MainActivityRepository

public class MainActivityViewModel : ViewModel() {
    private var testTransaction: MutableLiveData<ArrayList<TransactionModel>> = MutableLiveData()

    fun init() {
        val mRepo = MainActivityRepository.getInstance()
        testTransaction = mRepo.getTransactions()
    }

    fun getTestTransaction(): LiveData<ArrayList<TransactionModel>> {
        return testTransaction
    }
}