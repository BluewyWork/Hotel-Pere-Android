package com.intermodular.hotel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.intermodular.hotel.domain.model.HotelRoom

@Entity(tableName = "room_table")
data class HotelRoomEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "section") val description: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "pricePerNight") val pricePerNight: Double,
    @ColumnInfo(name = "reserved") val reserved: Boolean,
    @ColumnInfo(name = "bed") val bed: Int
)

fun HotelRoom.toDatabase() = HotelRoomEntity(
    number = number,
    description = description,
    image = image,
    pricePerNight = pricePerNight,
    reserved = reserved,
    bed = numberOfBeds
)
