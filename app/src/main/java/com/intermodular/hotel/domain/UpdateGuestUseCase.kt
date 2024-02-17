package com.intermodular.hotel.domain

import com.intermodular.hotel.data.GuestRepository
import com.intermodular.hotel.data.TokenRepository
import com.intermodular.hotel.domain.model.Guest
import javax.inject.Inject

class UpdateGuestUseCase @Inject constructor(
    private val guestRepository: GuestRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun updateGuest(
        name: String,
        surname: String,
        email: String
    ): Boolean {
        val token = tokenRepository.getGuestTokenFromDatabase()

        token.ifBlank {
            return false
        }

        return guestRepository.updateGuestAtApi(token, Guest(name, surname, email))
    }
}