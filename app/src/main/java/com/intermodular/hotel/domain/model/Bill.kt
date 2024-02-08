package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.database.entities.BillEntity
import com.intermodular.hotel.data.model.BillModel

data class Bill(
    val guestName: String,
    val guestSurname: String,
    val totalAmountDue: Double
)

fun BillModel.toDomain() = Bill(
    guestName = guestName,
    guestSurname = guestSurname,
    totalAmountDue = totalAmountDue
)

fun BillEntity.toDomain() = Bill(
    guestName = guestName,
    guestSurname = guestSurname,
    totalAmountDue = totalAmountDue
)
