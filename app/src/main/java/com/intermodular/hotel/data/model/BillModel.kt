package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class BillModel(
    @SerializedName("customerName") val guestName: String,
    @SerializedName("customerSurname") val guestSurname: String,
    @SerializedName("totalAmountDue") val totalAmountDue: Double
)