package com.intermodular.hotel.data.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class RoomModel(
    @SerializedName("number") val number: Int,
    @SerializedName("section") val section: String,
    @SerializedName("pricePerNight") val pricePerNight: Double,
    @SerializedName("reserved") val reserved: Reserved,
    @SerializedName("image") val image: Image,
    @SerializedName("bed") val bed: Int
)

enum class Reserved {
    @SerializedName("cancelled")
    CANCELLED,
    @SerializedName("confirmed")
    CONFIRMED,
    @SerializedName("pending")
    PENDING
}
