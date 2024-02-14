package com.intermodular.hotel.domain

import com.intermodular.hotel.data.HotelRoomRepository
import com.intermodular.hotel.data.TokenRepository
import com.intermodular.hotel.domain.model.HotelRoom
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

        return hotelRoom ?: generateHotelRoom(roomNumber)
    }

    private fun generateHotelRoom(roomNumber: Int): HotelRoom {
        return HotelRoom(
            number = 101,
            description = "Deluxe room with a view",
            pricePerNight = 150.0,
            reservedDays = listOf(LocalDateTime.now().plusDays(1)), // Example reserved date
            image = "room101.jpg",
            numberOfBeds = 2
        )
    }
}