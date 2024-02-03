package com.intermodular.hotel.domain

import com.intermodular.hotel.domain.model.Room
import kotlin.random.Random

class GetAllHotelRoomsUseCase {
    suspend operator fun invoke(): List<Room> {
        return generateRooms()
    }

    private suspend fun generateRooms(): List<Room> {
        val rooms = mutableListOf<Room>()

        for (i in 1..10) {
            val room = Room(
                number = i,
                section = "Section ${Random.nextInt(1, 4)}",
                pricePerNight = Random.nextDouble(50.0, 200.0),
                reserved = Random.nextBoolean(),
                image = "https://example.com/room$i.jpg",
                bed = Random.nextInt(1, 4)
            )
            rooms.add(room)
        }
        return rooms
    }
}