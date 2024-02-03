package com.intermodular.hotel.domain.model

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