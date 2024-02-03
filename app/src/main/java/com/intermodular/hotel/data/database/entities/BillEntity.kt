package com.intermodular.hotel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bill_table")
data class BillEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "customerName") val customerName: String,
    @ColumnInfo(name = "customerSurname") val customerSurname: String,
    @ColumnInfo(name = "totalAmountDue") val totalAmountDue: Double
)

fun BillEntity.toDatabase() = BillEntity(
    customerName = customerName,
    customerSurname = customerSurname,
    totalAmountDue = totalAmountDue
)