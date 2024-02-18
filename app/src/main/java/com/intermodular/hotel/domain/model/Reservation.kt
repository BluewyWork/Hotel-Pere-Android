package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.database.entities.ReservationEntity
import com.intermodular.hotel.data.model.ReservationModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Reservation(
    val guestName: String,
    val guestSurname: String,
    val guestEmail: String,
    val roomNumber: Int,
    val pricePerNight: Double,
    val checkIn: LocalDateTime,
    val checkOut: LocalDateTime,
)

fun convertToLocalDateTime(dateString: String): LocalDateTime {
    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

    return LocalDateTime.parse(dateString, dateTimeFormatter)
}

fun ReservationModel.toDomain() = Reservation(
    guestName = guestName,
    guestSurname = guestSurname,
    guestEmail = guestEmail,
    roomNumber = roomNumber,
    pricePerNight = pricePerNight,
    checkIn = convertToLocalDateTime(checkIn),
    checkOut = convertToLocalDateTime(checkOut),
)

fun ReservationEntity.toDomain() = Reservation(
    guestName = guestName,
    guestSurname = guestSurname,
    guestEmail = guestEmail,
    roomNumber = roomNumber,
    pricePerNight = pricePerNight,
    checkIn = convertToLocalDateTime(checkIn),
    checkOut = convertToLocalDateTime(checkOut),
)