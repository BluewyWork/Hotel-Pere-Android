package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

class GuestPlusPasswordModel(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("passwordConfirm") val passwordConfirm: String? = null
)