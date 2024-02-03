package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.model.HotelRoomModel

data class HotelRoom(
    val number: Int, val section: String,
    val pricePerNight: Double,
    val reserved: Boolean,
    val image: String,
    val bed: Int
)

fun HotelRoomModel.toDomain() = HotelRoom(number, section, pricePerNight, reserved, image, bed)
// fun RoomEntity.toDomain() = Room(number,section,pricePerNight,reserved, image, bed)
