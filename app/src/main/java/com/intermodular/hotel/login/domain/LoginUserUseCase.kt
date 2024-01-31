package com.intermodular.hotel.login.domain

import com.intermodular.hotel.data.UserRepository

class LoginUserUseCase {
    // private val api = AuthRepository()

    suspend fun login(email: String, password: String): Boolean {
        // val response = authService.login(username, password)
        // return response.isSuccessful
        return true
    }
}