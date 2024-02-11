package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class HotelRoomModel(
    @SerializedName("number") val number: Int,
    @SerializedName("section") val section: String,
    @SerializedName("pricePerNight") val pricePerNight: Double,
    @SerializedName("reserved") val description: Boolean,
    @SerializedName("image") val image: String,
    @SerializedName("beds") val numberOfBeds: Int
)


