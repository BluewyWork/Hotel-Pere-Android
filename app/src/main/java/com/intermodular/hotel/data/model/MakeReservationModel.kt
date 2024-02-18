package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class MakeReservationModel(
    @SerializedName("roomNumber") val roomNumber: Int,
    @SerializedName("checkIn") val checkIn: String,
    @SerializedName("checkOut") val checkOut: String
)