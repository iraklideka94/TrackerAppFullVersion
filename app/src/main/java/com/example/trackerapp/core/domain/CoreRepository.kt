package com.example.trackerapp.core.domain

interface CoreRepository {

    suspend fun updateBalance(balance: Double)
    suspend fun getBalance(): Double
}