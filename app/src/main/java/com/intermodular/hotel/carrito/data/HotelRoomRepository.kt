package com.intermodular.hotel.carrito.data

import com.intermodular.hotel.carrito.data.model.HotelRoomModel
import com.intermodular.hotel.carrito.data.model.HotelRoomProvider
import com.intermodular.hotel.carrito.data.network.HotelRoomService

class HotelRoomRepository {
    private val api = HotelRoomService()

    suspend fun getAllHotelRooms(): List<HotelRoomModel> {
        val response = api.getHotelRooms()
        HotelRoomProvider.hotelRooms = response
        return response
    }
}