package com.intermodular.hotel.login.domain

import com.intermodular.hotel.registro.network.response.RegistroRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val RegistroRepository: RegistroRepository) {
    //suspend operator fun invoke() = RegistroRepository.getUser()
}