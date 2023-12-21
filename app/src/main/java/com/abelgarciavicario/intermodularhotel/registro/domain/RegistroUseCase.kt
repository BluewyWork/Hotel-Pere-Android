package com.abelgarciavicario.intermodularhotel.login.domain

import com.abelgarciavicario.intermodularhotel.login.network.RegistroRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val networkRepository: RegistroRepository)