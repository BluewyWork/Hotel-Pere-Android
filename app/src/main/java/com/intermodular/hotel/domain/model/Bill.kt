package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.database.entities.BillEntity
import com.intermodular.hotel.data.model.BillModel

data class Bill(
    val customerName: String,
    val customerSurname: String,
    val totalAmountDue: Double
)

fun BillModel.toDomain() = Bill(
    customerName = customerName,
    customerSurname = customerSurname,
    totalAmountDue = totalAmountDue
)

fun BillEntity.toDomain() = Bill(
    customerName = customerName,
    customerSurname = customerSurname,
    totalAmountDue = totalAmountDue
)
