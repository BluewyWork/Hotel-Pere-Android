package com.intermodular.hotel.domain

import com.intermodular.hotel.data.ReservationRepository
import com.intermodular.hotel.data.TokenRepository
import com.intermodular.hotel.domain.model.HotelRoom
import javax.inject.Inject

class MakeReservationUseCase @Inject constructor(
    private val reservationRepository: ReservationRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun makeReservation(hotelRoom: HotelRoom) {
        val tokenFromGuest = tokenRepository.getGuestTokenFromDatabase().ifEmpty {
            return
        }

        // faltaria saber si lo hizo o no
        reservationRepository.makeReservation(tokenFromGuest, hotelRoom.number)
    }
}