package com.example.trackerapp.core.domain

import java.time.ZonedDateTime

interface LocalSpendingDataSource {

    suspend fun getAllSpendings(): List<Spending>

    suspend fun getSpendingByDate(
        dateTimeUtc: ZonedDateTime
    ): List<Spending>

    suspend fun getAllDates(): List<ZonedDateTime>

    suspend fun getSpending(id: Int): Spending

    suspend fun upsertSpending(spending: Spending)

    suspend fun getSpendBalance(): Double

    suspend fun deleteSpending(id: Int)
}