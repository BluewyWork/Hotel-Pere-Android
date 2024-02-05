package com.intermodular.hotel.data

import com.intermodular.hotel.data.model.HotelRoomModel
import com.intermodular.hotel.data.network.HotelRoomService
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject

class HotelRoomRepository @Inject constructor(
    private val api: HotelRoomService,
) {
    suspend fun getHotelRoomListFromApi(): List<HotelRoom> {
        val response: List<HotelRoomModel> = api.getHotelRoomList()
        return response.map { it.toDomain() }
    }

    suspend fun getOneHotelRoomFromApi(roomNumber: Int): HotelRoom? {
        val response: HotelRoomModel? = api.getOneHotelRoom(roomNumber)
        return response?.toDomain()
    }
}