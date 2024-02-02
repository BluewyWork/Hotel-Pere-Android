package com.intermodular.hotel.home.data

import com.intermodular.hotel.home.data.model.HotelRoomModel
import com.intermodular.hotel.home.data.model.HotelRoomProvider
import com.intermodular.hotel.home.data.network.HotelRoomService

class HotelRoomRepository {
    private val api = HotelRoomService()

    suspend fun getAllHotelRooms(): List<HotelRoomModel> {
        val response = api.getHotelRooms()
        HotelRoomProvider.hotelRooms = response
        return response
    }
}