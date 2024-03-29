package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName
import com.intermodular.hotel.domain.model.Reservation

data class ReservationModel(
    @SerializedName("guestName") val guestName: String,
    @SerializedName("guestSurname") val guestSurname: String,
    @SerializedName("guestEmail") val guestEmail: String,
    @SerializedName("roomNumber") val roomNumber: Int,
    @SerializedName("pricePerNight") val pricePerNight: Double,
    @SerializedName("checkIn") val checkIn: String,
    @SerializedName("checkOut") val checkOut: String,
)

fun Reservation.toModel() = ReservationModel(
    guestName = guestName,
    guestSurname = guestSurname,
    guestEmail = guestEmail,
    roomNumber = roomNumber,
    pricePerNight = pricePerNight,
    checkIn = checkIn.toString(),
    checkOut = checkOut.toString(),
)