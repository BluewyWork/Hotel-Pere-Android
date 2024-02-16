package com.intermodular.hotel.domain

import com.intermodular.hotel.data.GuestRepository
import com.intermodular.hotel.domain.model.Guest
import javax.inject.Inject

class GetAuthenticatedGuestUseCase @Inject constructor(
    private val guestRepository: GuestRepository
) {
    suspend operator fun invoke(): Guest? {
        val retrievedGuest = guestRepository.getAuthenticatedGuestFromDataBase()

        return retrievedGuest
    }

    private suspend fun generateGuest(): Guest {
        val name = "John"
        val surname = "Doe"
        val email = "john.doe@example.com"
        val token = "239tn_3nus3t4ner3o"

        return Guest(name, surname, email)
    }
}