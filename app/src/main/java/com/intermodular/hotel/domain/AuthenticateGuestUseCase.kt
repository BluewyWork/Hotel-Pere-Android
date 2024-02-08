package com.intermodular.hotel.domain

import android.util.Log
import com.intermodular.hotel.data.GuestRepository
import com.intermodular.hotel.data.model.LoginModel
import javax.inject.Inject

class AuthenticateGuestUseCase @Inject constructor(
    private val guestRepository: GuestRepository
) {
    suspend fun login(email: String, password: String): Boolean {
        val loginModel = LoginModel(email, password)
        val response = guestRepository.loginGuestFromApi(loginModel)

        Log.d("LOOK AT ME", "${response}")

        return response.isNotBlank()
    }
}