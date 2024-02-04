package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.model.HotelRoomModel

data class HotelRoom(
    val number: Int,
    val description: String,
    val pricePerNight: Double,
    val reserved: Boolean,
    val image: String,
    val numberOfBeds: Int
)

fun HotelRoomModel.toDomain() =
    HotelRoom(number, section, pricePerNight, description, image, numberOfBeds)
// fun RoomEntity.toDomain() = Room(number,section,pricePerNight,reserved, image, bed)
