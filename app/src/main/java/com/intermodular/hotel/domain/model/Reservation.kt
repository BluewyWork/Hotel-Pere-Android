package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.database.entities.ReservationEntity
import com.intermodular.hotel.data.model.ReservationModel
import java.util.Date

data class Reservation(
    val customerName: String,
    val customerSurname: String,
    val customerEmail: String,
    val roomNumber: Int,
    val pricePerNight: Double,
    val checkIn: Date,
    val checkOut: Date,
    val reserved: Boolean
)

fun ReservationModel.toDomain() = Reservation(
    customerName = customerName,
    customerSurname = customerSurname,
    customerEmail = customerEmail,
    roomNumber = roomNumber,
    pricePerNight = pricePerNight,
    checkIn = checkIn,
    checkOut = checkOut,
    reserved = reserved
)

fun ReservationEntity.toDomain() = Reservation(
customerName = customerName,
customerSurname = customerSurname,
customerEmail = customerEmail,
roomNumber = roomNumber,
pricePerNight = pricePerNight,
checkIn = checkIn,
checkOut = checkOut,
reserved = reserved
)