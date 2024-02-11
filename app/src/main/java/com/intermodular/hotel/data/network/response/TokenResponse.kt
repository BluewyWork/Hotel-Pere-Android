package com.intermodular.hotel.data.network.response

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("data") val data: Data1,
    @SerializedName("status") val status: Int,
    @SerializedName("ok") val ok: Boolean
)

data class Data1(
    @SerializedName("token") val token: String
)