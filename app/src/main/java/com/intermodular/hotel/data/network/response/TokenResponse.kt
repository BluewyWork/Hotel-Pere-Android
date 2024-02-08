package com.intermodular.hotel.data.network.response

import com.google.gson.annotations.SerializedName

data class TokenResponse (
    @SerializedName("data") val data: Data,
    @SerializedName("status") val status: Int,
    @SerializedName("ok") val ok: Boolean
)

data class Data (
    @SerializedName("token") val token: String
)