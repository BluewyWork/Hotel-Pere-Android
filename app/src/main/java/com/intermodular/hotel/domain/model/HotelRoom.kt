package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.model.HotelRoomModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class HotelRoom(
    val number: Int,
    val description: String,
    val pricePerNight: Double,
    val reservedDays: List<LocalDateTime>,
    val image: String,
    val numberOfBeds: Int
)

fun HotelRoomModel.toDomain() =
    HotelRoom(
        number,
        description,
        pricePerNight,
        convertToLocalDateTimeList(reservedDays),
        image,
        numberOfBeds
    )

fun convertToLocalDateTimeList(list: List<String>): List<LocalDateTime> {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    return list.map { LocalDateTime.parse(it, formatter) }
}