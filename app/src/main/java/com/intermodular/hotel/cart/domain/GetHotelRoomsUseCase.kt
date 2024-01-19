package com.intermodular.hotel.cart.domain

import com.intermodular.hotel.cart.data.HotelRoomRepository
import com.intermodular.hotel.cart.data.model.HotelRoomModel

class GetHotelRoomsUseCase {
    private val repository = HotelRoomRepository()

    suspend operator fun invoke(): List<HotelRoomModel> {
        return repository.getAllHotelRooms()
    }
}