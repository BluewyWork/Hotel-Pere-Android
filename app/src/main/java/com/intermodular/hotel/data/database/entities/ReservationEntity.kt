package com.intermodular.hotel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservation_table")
data class ReservationEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "customerName") val guestName: String,
    @ColumnInfo(name = "customerSurname") val guestSurname: String,
    @ColumnInfo(name = "customerEmail") val guestEmail: String,
    @ColumnInfo(name = "roomNumber") val roomNumber: Int,
    @ColumnInfo(name = "pricePerNight") val pricePerNight: Double,
    @ColumnInfo(name = "checkIn") val checkIn: String,
    @ColumnInfo(name = "checkOut") val checkOut: String,
    @ColumnInfo(name = "reserved") val reserved: Boolean
)

fun ReservationEntity.toDatabase() = ReservationEntity(
    guestName = guestName,
    guestSurname = guestSurname,
    guestEmail = guestEmail,
    roomNumber = roomNumber,
    pricePerNight = pricePerNight,
    checkIn = checkIn,
    checkOut = checkOut,
    reserved = reserved
)