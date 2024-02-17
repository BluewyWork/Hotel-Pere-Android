package com.intermodular.hotel.domain

import com.intermodular.hotel.data.GuestRepository
import com.intermodular.hotel.data.TokenRepository
import javax.inject.Inject

class DeleteGuestUseCase @Inject constructor(
    private val guestRepository: GuestRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun deleteGuest(): Boolean {
        val token = tokenRepository.getGuestTokenFromDatabase()

        return guestRepository.deleteGuestAtApi(token)
    }
}