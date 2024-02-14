package com.intermodular.hotel.domain

import com.intermodular.hotel.data.HotelRoomRepository
import com.intermodular.hotel.domain.model.HotelRoom
import java.time.LocalDateTime
import javax.inject.Inject

class GetHotelRoomListUseCase @Inject constructor(
    private val repository: HotelRoomRepository
) {
    suspend operator fun invoke(): List<HotelRoom> {
        val hotelRoomListFromApi = repository.getHotelRoomListFromApi()

        return hotelRoomListFromApi.ifEmpty {
            generateHotelRooms()
        }
    }

    private fun generateHotelRooms(): List<HotelRoom> {
        val rooms = mutableListOf<HotelRoom>()

        for (i in 1..10) {
            val room = HotelRoom(
                number = 101,
                description = "Deluxe room with a view",
                pricePerNight = 150.0,
                reservedDays = listOf(LocalDateTime.now().plusDays(1)), // Example reserved date
                image = "room101.jpg",
                numberOfBeds = 2
            )

            rooms.add(room)
        }

        return rooms
    }
}