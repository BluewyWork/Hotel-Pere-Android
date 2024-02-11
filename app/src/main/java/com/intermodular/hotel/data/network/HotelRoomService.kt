package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.HotelRoomModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HotelRoomService @Inject constructor(
    private val hotelRoomApi: HotelRoomApi
) {
    suspend fun getHotelRoomListFromApi(): List<HotelRoomModel> {
        return withContext(Dispatchers.IO) {
            try {
                val response = hotelRoomApi.getHotelRoomList().data
                response
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
                emptyList()
            }
        }
    }

    suspend fun getOneHotelRoomFromApi(roomNumber: Int): HotelRoomModel {
        return withContext(Dispatchers.IO) {
            try {
                val response = hotelRoomApi.getOneHotelRoom(roomNumber)
                response
            } catch (e: Exception) {
                HotelRoomModel(1, "1", 1.0, true, "tt", 1)
            }
        }
    }
}