package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.database.entities.GuestEntity
import com.intermodular.hotel.data.model.GuestModel

data class Guest(
    val name: String,
    val surname: String,
    val email: String,
    val token: String
)

fun GuestModel.toDomain() = Guest(name, surname, email, token)
fun GuestEntity.toDomain() = Guest(name, surname, email, token)


