package com.intermodular.hotel.domain

import android.util.Log
import com.intermodular.hotel.data.ReservationRepository
import com.intermodular.hotel.data.TokenRepository
import com.intermodular.hotel.domain.model.HotelRoom
import java.time.LocalDate
import javax.inject.Inject

class MakeReservationUseCase @Inject constructor(
    private val reservationRepository: ReservationRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun makeReservation(
        hotelRoom: HotelRoom,
        checkIn: LocalDate,
        checkOut: LocalDate
    ): Boolean {
        val tokenFromGuest = tokenRepository.getGuestTokenFromDatabase().ifEmpty {
            Log.e("LOOK AT ME", "Missing token...")
            return false
        }

        val success = reservationRepository.makeReservation(
            tokenFromGuest = tokenFromGuest,
            roomNumber = hotelRoom.number,
            checkIn = checkIn,
            checkOut = checkOut
        )

        if (!success) {
            Log.e("LOOK AT ME", "Unable to make reservation...")
            return false
        }

        return true
    }
}