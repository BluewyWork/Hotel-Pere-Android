package com.abelgarciavicario.intermodularhotel.log.domain

import com.abelgarciavicario.intermodularhotel.log.network.RegistroRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val networkRepository: RegistroRepository){
}