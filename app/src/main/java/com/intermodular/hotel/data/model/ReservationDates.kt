package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class ReservationDates(
    @SerializedName("checkIn") val checkIn: String,
    @SerializedName("checkOut") val checkOut: String,
)