package com.intermodular.hotel.domain

import com.intermodular.hotel.data.HotelRoomRepository
import com.intermodular.hotel.domain.model.HotelRoom
import javax.inject.Inject

class GetDetailsOfRoomUseCase @Inject constructor(
    private val repository: HotelRoomRepository
) {
    /*suspend fun getDetailsOfRoom(roomNumber: Int): HotelRoom {
        val hotelRoom = repository.getOneHotelRoomFromApi(roomNumber)

        return hotelRoom ?: generateHotelRoom()
    }*/

    private fun generateHotelRoom(): HotelRoom {
        return HotelRoom(
            number = 1,
            description = "Very beautiful room!",
            pricePerNight = 100.0 + 1 * 10,
            reserved = false,
            image = "room_image_1.jpg",
            numberOfBeds = 2
        )
    }
}