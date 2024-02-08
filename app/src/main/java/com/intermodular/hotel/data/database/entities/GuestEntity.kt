package com.intermodular.hotel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.intermodular.hotel.domain.model.Guest

@Entity(tableName = "customer_table")
data class GuestEntity(
    @PrimaryKey(autoGenerate = false)//En caso de necesitar id autogenerado true @ColumnInfo(name="id") val id: Int =0,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "token") val token: String,
    //@ColumnInfo (name="image") val image: ByteArray?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: String
)

fun Guest.toDatabase() = GuestEntity(
    name = name,
    surname = surname,
    email = email,
    token = token
)