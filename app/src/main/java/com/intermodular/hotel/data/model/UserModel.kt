package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("token") val token: String
)
