package com.intermodular.hotel.domain.model

import android.media.Image
import com.intermodular.hotel.data.model.RoomModel


data class Room(
    val number: Int, val section: String,
    val pricePerNight: Double,
    val reserved: Boolean,
    val image: String,
    val bed: Int
)

fun RoomModel.toDomain() = Room(number, section, pricePerNight, reserved, image, bed)
// fun RoomEntity.toDomain() = Room(number,section,pricePerNight,reserved, image, bed)
