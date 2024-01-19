package com.intermodular.hotel.carrito.domain

import com.intermodular.hotel.carrito.data.HotelRoomRepository
import com.intermodular.hotel.carrito.data.model.HotelRoomModel

class GetHotelRoomsUseCase {
    private val repository = HotelRoomRepository()

    suspend operator fun invoke(): List<HotelRoomModel> {
        return repository.getAllHotelRooms()
    }
}