package com.intermodular.hotel.domain

import com.intermodular.hotel.data.GuestRepository
import javax.inject.Inject

class RegisterGuestUseCase @Inject constructor(
    private val guestRepository: GuestRepository
) {
    suspend fun registerGuest(
        name: String,
        surname: String,
        email: String,
        password: String,
        passwordConfirm: String
    ): Boolean {
        return guestRepository.registerGuestToApi(name, surname, email, password ,passwordConfirm)
    }
}