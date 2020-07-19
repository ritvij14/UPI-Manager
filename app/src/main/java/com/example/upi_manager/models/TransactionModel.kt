package com.example.upi_manager.models

data class TransactionModel(
    var amount: Int? = 0,
    var type: String? = "",
    var info: String? = ""
)