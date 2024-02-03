package com.intermodular.hotel.domain

class LoginCustomerUseCase {
    // private val api = AuthRepository()
    suspend fun login(email: String, password: String): Boolean {
        // val response = authService.login(username, password)
        // return response.isSuccessful
        return true
    }
}