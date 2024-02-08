package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class ReservationModel(
    @SerializedName("customerName") val guestName: String,
    @SerializedName("customerSurname") val guestSurname: String,
    @SerializedName("customerEmail") val guestEmail: String,
    @SerializedName("roomNumber") val roomNumber: Int,
    @SerializedName("pricePerNight") val pricePerNight: Double,
    @SerializedName("checkIn") val checkIn: String,
    @SerializedName("checkOut") val checkOut: String,
    @SerializedName("reserved") val reserved: Boolean
)