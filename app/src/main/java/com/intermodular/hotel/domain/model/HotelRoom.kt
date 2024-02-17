package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.model.HotelRoomModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
            parseLocalDateTime(it.checkIn),
            parseLocalDateTime(it.checkOut)
        )
    },
    image,
    numberOfBeds
)

fun parseLocalDateTime(dateTimeString: String): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    return LocalDateTime.parse(dateTimeString, formatter)
}