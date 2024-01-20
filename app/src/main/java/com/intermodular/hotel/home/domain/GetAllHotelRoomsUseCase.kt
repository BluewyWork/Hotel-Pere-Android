package com.intermodular.hotel.home.domain

import com.intermodular.hotel.home.data.HotelRoomRepository
import com.intermodular.hotel.home.data.model.HotelRoomModel

class GetAllHotelRoomsUseCase {
    private val repository = HotelRoomRepository()

    suspend operator fun invoke(): List<HotelRoomModel> {
        return repository.getAllHotelRooms()
    }
}