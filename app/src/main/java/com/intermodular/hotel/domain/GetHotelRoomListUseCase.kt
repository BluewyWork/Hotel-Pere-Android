package com.intermodular.hotel.domain

import com.intermodular.hotel.data.RoomRepository
import com.intermodular.hotel.domain.model.HotelRoom
import javax.inject.Inject

class GetHotelRoomListUseCase @Inject constructor(
    private val repository: RoomRepository
) {
    suspend operator fun invoke(): List<HotelRoom> {
        val x = repository.getHotelRoomListFromApi()

        return x.ifEmpty {
            generateHotelRooms()
        }
    }

    private fun generateHotelRooms(): List<HotelRoom> {
        val rooms = mutableListOf<HotelRoom>()

        for (i in 1..10) {
            val room = HotelRoom(
                number = i,
                description = "Very beautiful room!",
                pricePerNight = 100.0 + i * 10,
                reserved = false,
                image = "room_image_$i.jpg",
                numberOfBeds = 2
            )

            rooms.add(room)
        }

        return rooms
    }
}