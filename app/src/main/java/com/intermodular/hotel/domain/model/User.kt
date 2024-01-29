package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.database.entities.UserEntity
import com.intermodular.hotel.data.model.UserModel

data class User(val name: String, val email: String, val token: String)

fun UserModel.toDomain() = User(name, email, token)
fun UserEntity.toDomain() = User(name, email, token)


