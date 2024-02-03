package com.intermodular.hotel.domain

class GetCustomerProfileUseCase {
    // private val api = Repository()

    suspend fun getUsername(): String {
        return "Asier"
    }

    suspend fun getLastName(): String {
        return "Abel"
    }

    suspend fun getPhoneNumber(): String {
        return "+34 555 55 55 55"
    }

    suspend fun getEmail(): String {
        return "abel.asier@gmail.com"
    }
}