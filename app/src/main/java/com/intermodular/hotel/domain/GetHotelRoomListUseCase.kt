package com.intermodular.hotel.domain

import com.intermodular.hotel.data.HotelRoomRepository
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.domain.model.ReservedDateRange
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

            val room = HotelRoom(
                number = 101,
                description = "Standard Room",
                image = "https://images.unsplash.com/photo-1568495248636-6432b97bd949?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGhvdGVsJTIwcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                pricePerNight = 99.99,
                reservedDays = reservedDates,
                numberOfBeds = 2
            )

            rooms.add(room)
        }

        return rooms
    }
}