package com.intermodular.hotel.domain

import com.intermodular.hotel.domain.model.HotelRoom
import kotlin.random.Random

class GetAllHotelRoomsUseCase {
    suspend operator fun invoke(): List<HotelRoom> {
        return generateRooms()
    }

    private suspend fun generateRooms(): List<HotelRoom> {
        val hotelRooms = mutableListOf<HotelRoom>()

        for (i in 1..10) {
            val hotelRoom = HotelRoom(
                number = i,
                section = "Section ${Random.nextInt(1, 4)}",
                pricePerNight = Random.nextDouble(50.0, 200.0),
                reserved = Random.nextBoolean(),
                image = "https://example.com/room$i.jpg",
                bed = Random.nextInt(1, 4)
            )
            hotelRooms.add(hotelRoom)
        }
        return hotelRooms
    }
}