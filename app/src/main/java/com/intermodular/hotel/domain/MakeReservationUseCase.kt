package com.intermodular.hotel.domain

import com.intermodular.hotel.data.GuestRepository
import com.intermodular.hotel.data.ReservationRepository
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.domain.model.Reservation
import java.time.LocalDateTime
import javax.inject.Inject

class MakeReservationUseCase @Inject constructor(
    private val reservationRepository: ReservationRepository,
    private val guestRepository: GuestRepository
) {
    suspend fun makeReservation(hotelRoom: HotelRoom) {
        val guest = guestRepository.getAuthenticatedGuestFromDataBase() ?: return

        val reservation = Reservation(
            guestName = guest.name,
            guestSurname = guest.surname,
            guestEmail = guest.email,
            roomNumber = hotelRoom.number,
            pricePerNight = hotelRoom.pricePerNight,
            checkIn = LocalDateTime.now(),
            checkOut = LocalDateTime.now(),
            reserved = true
        )

        reservationRepository.makeReservation(reservation)
    }
}