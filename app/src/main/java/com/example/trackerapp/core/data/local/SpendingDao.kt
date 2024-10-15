package com.example.trackerapp.core.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface SpendingDao {

    @Upsert
    suspend fun upsertSpending(entity: SpendingEntity)


    @Query("SELECT * FROM spendingEntity")
    suspend fun getAllSpendings(): List<SpendingEntity>

    @Query("SELECT * FROM spendingEntity WHERE spendingId = :id")
    suspend fun getSpending(id: Int): SpendingEntity

    @Query("SELECT SUM(price) FROM spendingEntity")
    suspend fun getSpendBalance(): Double?

    @Query("SELECT dateTimeUtc FROM spendingEntity")
    suspend fun getAllDates(): List<String>


    @Query("DELETE FROM spendingEntity WHERE spendingId = :id")
    suspend fun deleteSpending(id: Int)
}