package com.intermodular.hotel.home.data

import com.intermodular.hotel.home.data.network.HotelRoomService
import com.intermodular.hotel.home.data.model.HotelRoomModel
import com.intermodular.hotel.home.data.model.HotelRoomProvider

class HotelRoomRepository {
    private val api = HotelRoomService()

    suspend fun getAllHotelRooms(): List<HotelRoomModel> {
        val response = api.getHotelRooms()
        HotelRoomProvider.hotelRooms = response
        return response
    }
}