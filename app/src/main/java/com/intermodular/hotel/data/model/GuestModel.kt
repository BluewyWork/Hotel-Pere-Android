package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class GuestModel(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("email") val email: String,
)
