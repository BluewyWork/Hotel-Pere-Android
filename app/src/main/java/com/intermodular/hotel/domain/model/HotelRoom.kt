package com.intermodular.hotel.domain.model

import android.util.Log
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
// fun RoomEntity.toDomain() = Room(number,section,pricePerNight,reserved, image, bed)

//fun HotelRoomModel.toDomain(): HotelRoom {
//    val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
//    val reservedDaysList = reservedDays.map { LocalDateTime.parse(it, formatter) }
//    return HotelRoom(number, description, pricePerNight, reservedDaysList, image, numberOfBeds)
//}

//fun convertToLocalDateTimeList(list: List<String>): List<LocalDateTime> {
//    return try {
//        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
//        list.map { LocalDateTime.parse(it, formatter) }
//    } catch (e: Exception) {
//        Log.e("LOOK AT ME", "${e.message}")
//        emptyList()
//    }
//}

fun convertToLocalDateTimeList(list: List<String>): List<LocalDateTime> {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    return list.map { LocalDateTime.parse(it, formatter) }
}