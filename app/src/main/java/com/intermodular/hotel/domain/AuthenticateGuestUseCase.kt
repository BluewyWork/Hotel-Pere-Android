package com.intermodular.hotel.domain

import android.util.Log
import com.intermodular.hotel.data.GuestRepository
import com.intermodular.hotel.data.TokenRepository
import com.intermodular.hotel.data.database.entities.TokenEntity
import com.intermodular.hotel.data.model.LoginModel
import javax.inject.Inject

class AuthenticateGuestUseCase @Inject constructor(
    private val guestRepository: GuestRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun login(email: String, password: String): Boolean {
        val loginModel = LoginModel(email, password)
        val guestToken = tokenRepository.getGuestTokenFromApi(loginModel)

        if (guestToken.isBlank()) {
            Log.e("LOOK AT ME", "API RESPONSE: Blank")
            return false
        }

        val guest = guestRepository.getAuthenticatedGuestFromApi(guestToken)

        if (guest == null) {
            Log.e("LOOK AT ME", "API RESPONSE: NULL")
            return false
        }

        val tokenEntity = TokenEntity(guestToken)
        tokenRepository.clearAllTokensFromDatabase()
        tokenRepository.insertOneTokenToDatabase(tokenEntity)

        guestRepository.clearGuestFromDatabase()
        guestRepository.insertOneGuestToDatabase(guest)

        return true
    }
}