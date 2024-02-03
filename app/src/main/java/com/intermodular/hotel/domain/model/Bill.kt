package com.intermodular.hotel.domain.model

data class Bill(
    val customerName: String,
    val customerSurname: String,
    val totalAmountDue: Double
)