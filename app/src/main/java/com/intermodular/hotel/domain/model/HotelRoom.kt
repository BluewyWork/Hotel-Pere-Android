package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.model.HotelRoomModel
import java.time.LocalDateTime

data class HotelRoom(
    val number: Int,
    val description: String,
    val pricePerNight: Double,
    val reservedDays: List<ReservedDateRange>,
    val image: String,
    val numberOfBeds: Int
)

data class ReservedDateRange(
    val reservationId: String,
    val checkIn: LocalDateTime,
    val checkOut: LocalDateTime
)

fun HotelRoomModel.toDomain() = HotelRoom(
    number,
    description,
    pricePerNight,
    reservedDays.map {
        ReservedDateRange(
            it.reservationId,
            LocalDateTime.parse(it.checkIn),
            LocalDateTime.parse(it.checkOut)
        )
    },
    image,
    numberOfBeds
)