package com.intermodular.hotel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "reservation_table")
data class ReservationEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "customerName") val customerName: String,
    @ColumnInfo(name = "customerSurname") val customerSurname: String,
    @ColumnInfo(name = "roomNumber") val roomNumber: Int,
    @ColumnInfo(name = "pricePerNight") val pricePerNight: Double,
    @ColumnInfo(name = "checkIn") val checkIn: Date,
    @ColumnInfo(name = "checkOut") val checkOut: Date
)