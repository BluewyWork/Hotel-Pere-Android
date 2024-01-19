package com.intermodular.hotel.cart.data

import com.intermodular.hotel.cart.data.model.HotelRoomModel
import com.intermodular.hotel.cart.data.model.HotelRoomProvider
import com.intermodular.hotel.cart.data.network.HotelRoomService

class HotelRoomRepository {
    private val api = HotelRoomService()

    suspend fun getAllHotelRooms(): List<HotelRoomModel> {
        val response = api.getHotelRooms()
        HotelRoomProvider.hotelRooms = response
        return response
    }
}