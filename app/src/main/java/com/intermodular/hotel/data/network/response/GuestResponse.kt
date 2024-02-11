package com.intermodular.hotel.data.network.response

import com.google.gson.annotations.SerializedName

data class GuestResponse(
    @SerializedName("data") val data: Data2,
    @SerializedName("status") val status: Int,
    @SerializedName("ok") val ok: Boolean
)

data class Data2(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("email") val email: String
)