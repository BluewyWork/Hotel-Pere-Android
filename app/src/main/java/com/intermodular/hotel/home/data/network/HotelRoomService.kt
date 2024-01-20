package com.intermodular.hotel.home.data.network

import com.intermodular.hotel.home.data.model.HotelRoomModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HotelRoomService {
    suspend fun getHotelRooms(): List<HotelRoomModel> {
        return withContext(Dispatchers.IO) {
            generateHotelRooms() ?: emptyList()
        }
    }
}

// placeholder for API
fun generateHotelRooms(): List<HotelRoomModel>? {
    val hotelRooms: MutableList<HotelRoomModel> = emptyList<HotelRoomModel>().toMutableList()

    hotelRooms.add(HotelRoomModel("230948290f", 42.234))

    return hotelRooms
}