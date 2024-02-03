package com.intermodular.hotel.data.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class RoomModel(
    @SerializedName("number") val number: Int,
    @SerializedName("section") val section: String,
    @SerializedName("pricePerNight") val pricePerNight: Double,
    @SerializedName("reserved") val reserved: Boolean,
    @SerializedName("image") val image: String,
    @SerializedName("bed") val bed: Int
)


