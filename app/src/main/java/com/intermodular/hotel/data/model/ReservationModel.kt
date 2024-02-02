package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ReservationModel(
    @SerializedName("customerName") val customerName: String,
    @SerializedName("customerEmail") val customerEmail: String,
    @SerializedName("roomNumber") val roomNumber: Int,
    @SerializedName("pricePerNight") val pricePerNight: Double,
    @SerializedName("checkIn") val checkIn: Date,
    @SerializedName("checkOut") val checkOut: Date
)