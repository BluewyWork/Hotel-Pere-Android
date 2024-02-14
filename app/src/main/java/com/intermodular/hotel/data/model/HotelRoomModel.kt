package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class HotelRoomModel(
    @SerializedName("number") val number: Int,
    @SerializedName("description") val description: String,
    @SerializedName("pricePerNight") val pricePerNight: Double,
    @SerializedName("reservedDays") val reservedDays: List<String>,
    @SerializedName("image") val image: String,
    @SerializedName("beds") val numberOfBeds: Int
)
