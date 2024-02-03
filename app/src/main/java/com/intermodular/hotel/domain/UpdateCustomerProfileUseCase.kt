package com.intermodular.hotel.domain

class UpdateCustomerProfileUseCase {
    // val api = Repository()

    suspend fun updateProfile(
        username: String,
        lastname: String,
        phoneNumber: String,
        email: String
    ): Boolean {
        // val response = api.updateProfile(username, lastname, phoneNumber, email)
        // return response = api.isSuccessful()
        return true
    }
}