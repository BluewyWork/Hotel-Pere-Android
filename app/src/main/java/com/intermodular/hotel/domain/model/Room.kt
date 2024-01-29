package com.intermodular.hotel.domain.model

import android.media.Image
import com.intermodular.hotel.data.database.entities.RoomEntity
import com.intermodular.hotel.data.model.Reserved
import com.intermodular.hotel.data.model.RoomModel


data class Room (val number: Int, val section: String,
                 val pricePerNight: Double, val reserved: Reserved,
                 val image: Image, val bed: Int
)

    fun RoomModel.toDomain() = Room(number,section,pricePerNight,reserved, image, bed)
   // fun RoomEntity.toDomain() = Room(number,section,pricePerNight,reserved, image, bed)
