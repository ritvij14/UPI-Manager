package com.example.upi_manager

interface DatabaseInterface {
    fun onRetrieveStart()
    fun onRetrieveSuccess()
    fun onRetrieveFailed()
}