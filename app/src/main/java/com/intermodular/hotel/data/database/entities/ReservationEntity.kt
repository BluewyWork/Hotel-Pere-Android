package com.intermodular.hotel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservation_table")
data class ReservationEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "customerName") val customerName: String,
    @ColumnInfo(name = "customerSurname") val customerSurname: String,
    @ColumnInfo(name = "customerEmail") val customerEmail: String,
    @ColumnInfo(name = "roomNumber") val roomNumber: Int,
    @ColumnInfo(name = "pricePerNight") val pricePerNight: Double,
    @ColumnInfo(name = "checkIn") val checkIn: String,
    @ColumnInfo(name = "checkOut") val checkOut: String,
    @ColumnInfo(name = "reserved") val reserved: Boolean
)

fun ReservationEntity.toDatabase() = ReservationEntity(
    customerName = customerName,
    customerSurname = customerSurname,
    customerEmail = customerEmail,
    roomNumber = roomNumber,
    pricePerNight = pricePerNight,
    checkIn = checkIn,
    checkOut = checkOut,
    reserved = reserved
)