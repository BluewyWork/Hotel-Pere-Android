package com.intermodular.hotel.domain

import com.intermodular.hotel.data.CustomerRepository
import com.intermodular.hotel.data.model.LoginModel
import javax.inject.Inject

class AuthenticateCustomerUseCase @Inject constructor(
    private val customerRepository: CustomerRepository
) {
    suspend fun login(email: String, password: String): Boolean {
        val loginModel = LoginModel(email, password)
        val response = customerRepository.loginCustomerFromApi(loginModel)

        return response.isNotBlank()
    }
}