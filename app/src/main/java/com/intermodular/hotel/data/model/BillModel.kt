package com.intermodular.hotel.data.model

import com.google.gson.annotations.SerializedName

data class BillModel(
    @SerializedName("customerName") val customerName: String,
    @SerializedName("customerSurname") val customerSurname: String,
    @SerializedName("totalAmountDue") val totalAmountDue: Double
)