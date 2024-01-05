package com.intermodular.hotel.login.domain

import com.intermodular.hotel.login.network.RegistroRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val networkRepository: RegistroRepository)