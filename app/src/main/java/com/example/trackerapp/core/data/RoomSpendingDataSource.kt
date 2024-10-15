package com.example.trackerapp.core.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.trackerapp.core.data.local.SpendingDao
import com.example.trackerapp.core.domain.LocalSpendingDataSource
import com.example.trackerapp.core.domain.Spending
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

class RoomSpendingDataSource(
    private val dao: SpendingDao
) : LocalSpendingDataSource {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getAllSpendings(): List<Spending> {
        return dao.getAllSpendings().map { it.toSpending() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getSpendingByDate(dateTimeUtc: ZonedDateTime): List<Spending> {
        return dao.getAllSpendings().map { it.toSpending() }
            .filter { spending ->
                spending.dateTimeUtc.dayOfMonth == dateTimeUtc.dayOfMonth
                        && spending.dateTimeUtc.month == dateTimeUtc.month
                        && spending.dateTimeUtc.year == dateTimeUtc.year
            }
    }

    override suspend fun getSpending(id: Int): Spending {
        return dao.getSpending(id).toSpending()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getAllDates(): List<ZonedDateTime> {
        val uniqueDates = mutableSetOf<ZonedDateTime>()
        return dao.getAllDates().map {
            Instant.parse(it).atZone(ZoneId.of("UTC"))
        }
            .filter {
                uniqueDates.add(it)
            }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun upsertSpending(spending: Spending) {
        dao.upsertSpending(spending.toNewSpendingEntity())
    }

    override suspend fun getSpendBalance(): Double {
        return dao.getSpendBalance() ?: 0.0
    }

    override suspend fun deleteSpending(id: Int) {
        dao.deleteSpending(id)
    }
}