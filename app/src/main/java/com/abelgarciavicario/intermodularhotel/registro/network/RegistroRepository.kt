package com.abelgarciavicario.intermodularhotel.log.network

import com.abelgarciavicario.intermodularhotel.log.network.response.RegistroService
import javax.inject.Inject

class RegistroRepository @Inject constructor(private val api: RegistroService){
}