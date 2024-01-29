package com.intermodular.hotel.data.database.entities

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.intermodular.hotel.data.model.Reserved
import com.intermodular.hotel.domain.model.Room


@Entity(tableName = "room_table")
data class RoomEntity(
    @PrimaryKey(autoGenerate = false)//En caso de necesitar id autogenerado true @ColumnInfo(name="id") val id: Int =0,
    @ColumnInfo(name="number") val number: Int,
    @ColumnInfo(name="section") val section: String,
    @ColumnInfo (name="image") val image: Image,
    @ColumnInfo(name="pricePerNight")val pricePerNight: Double,
    @ColumnInfo(name="reserved")val reserved: Reserved,
    @ColumnInfo(name="bed")val bed: Int
    )
    fun Room.toDatabase() = RoomEntity(number = number, section=section,image=image,
        pricePerNight=pricePerNight, reserved=reserved, bed= bed)
