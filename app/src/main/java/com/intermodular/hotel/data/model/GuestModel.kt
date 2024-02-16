package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName
import com.intermodular.hotel.domain.model.Guest

data class GuestModel(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("email") val email: String,
)

fun Guest.toModel() = GuestModel(
    name = name,
    surname = surname,
    email = email
)
