package com.intermodular.hotel.domain

import com.intermodular.hotel.data.TokenRepository
import javax.inject.Inject

class GuestUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend fun isLoggedIn(): Boolean {
        val token = tokenRepository.getGuestTokenFromDatabase()

        token.ifBlank {
            return false
        }

        return true
    }
}