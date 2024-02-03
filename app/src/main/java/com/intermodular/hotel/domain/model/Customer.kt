package com.intermodular.hotel.domain.model

import com.intermodular.hotel.data.database.entities.CustomerEntity
import com.intermodular.hotel.data.model.CustomerModel

data class Customer(
    val name: String,
    val surname: String,
    val email: String,
    val token: String
)

fun CustomerModel.toDomain() = Customer(name, surname, email, token)
fun CustomerEntity.toDomain() = Customer(name, surname, email, token)


