package com.intermodular.hotel.domain

import com.intermodular.hotel.data.HotelRoomRepository
import com.intermodular.hotel.data.TokenRepository
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.domain.model.ReservedDateRange
import java.time.LocalDateTime
import javax.inject.Inject

class GetDetailsOfRoomUseCase @Inject constructor(
    private val hotelRoomRepository: HotelRoomRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun isLoggedIn(): Boolean {
        val token = tokenRepository.getGuestTokenFromDatabase()

        return token.isNotBlank()
    }

    suspend fun getDetailsOfRoom(roomNumber: Int): HotelRoom {
        val hotelRoom = hotelRoomRepository.getOneHotelRoomFromApi(roomNumber)

        return hotelRoom ?: generateHotelRoom()
    }

    private fun generateHotelRoom(): HotelRoom {
        val reservedDates = listOf(
            ReservedDateRange(
                "reservation_id_1",
                LocalDateTime.of(2024, 2, 16, 14, 0),
                LocalDateTime.of(2024, 2, 20, 12, 0)
            ),
            ReservedDateRange(
                "reservation_id_2",
                LocalDateTime.of(2024, 3, 10, 14, 0),
                LocalDateTime.of(2024, 3, 15, 12, 0)
            )
        )

        return HotelRoom(
            number = 101,
            description = "Standard Room",
            image = "https://images.unsplash.com/photo-1568495248636-6432b97bd949?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGhvdGVsJTIwcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            pricePerNight = 99.99,
            reservedDays = reservedDates,
            numberOfBeds = 2
        )
    }
}