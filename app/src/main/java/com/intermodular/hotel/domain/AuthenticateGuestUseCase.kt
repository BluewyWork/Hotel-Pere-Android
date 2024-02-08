package com.intermodular.hotel.domain

import com.intermodular.hotel.data.GuestRepository
import com.intermodular.hotel.data.TokenRepository
import com.intermodular.hotel.data.database.entities.TokenEntity
import com.intermodular.hotel.data.database.entities.toDatabase
import com.intermodular.hotel.data.model.LoginModel
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject

class AuthenticateGuestUseCase @Inject constructor(
    private val guestRepository: GuestRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun login(email: String, password: String): Boolean {
        val loginModel = LoginModel(email, password)
        val guestToken = tokenRepository.getGuestTokenFromApi(loginModel)

        val guestModel = guestRepository.getAuthenticatedGuestFromApi(guestToken) ?: return false
        val guest = guestModel.toDomain()

        val tokenEntity = TokenEntity(guestToken)
        tokenRepository.clearAllTokensFromDatabase()
        tokenRepository.insertOneTokenToDatabase(tokenEntity)

        guestRepository.clearGuestFromDatabase()
        guestRepository.insertOneGuestToDatabase(guest.toDatabase())

        return true
    }
}