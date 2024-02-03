package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.HotelRoomModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomService @Inject constructor(private val api: RoomApiClient) {
    suspend fun getHotelRoomList(): List<HotelRoomModel> {
        return withContext(Dispatchers.IO) {
            api.getHotelRoomList().body() ?: emptyList()
        }
    }
}