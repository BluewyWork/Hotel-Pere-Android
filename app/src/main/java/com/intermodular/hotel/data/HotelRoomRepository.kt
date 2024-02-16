package com.intermodular.hotel.data

import android.util.Log
import com.intermodular.hotel.data.model.HotelRoomModel
import com.intermodular.hotel.data.network.HotelRoomService
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject

class HotelRoomRepository @Inject constructor(
    private val api: HotelRoomService,
) {
    suspend fun getHotelRoomListFromApi(): List<HotelRoom> {
        return try {
            val response: List<HotelRoomModel> = api.getHotelRoomListFromApi()
            response.map { it.toDomain() }
        } catch (e: Exception) {
            Log.e("LOOK AT ME", "ERROR: ${e.message}")
            emptyList()
        }
    }

    suspend fun getOneHotelRoomFromApi(roomNumber: Int): HotelRoom? {
        val response: HotelRoomModel? = api.getOneHotelRoomFromApi(roomNumber)
        return response?.toDomain()
    }
}