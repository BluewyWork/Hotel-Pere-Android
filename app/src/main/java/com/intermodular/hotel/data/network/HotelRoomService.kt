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
                hotelRoomApi.getHotelRoomList().body()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            emptyList()
        }
    }

    suspend fun getOneHotelRoomFromApi(roomNumber: Int): HotelRoomModel? {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext hotelRoomApi.getOneHotelRoom(roomNumber).body()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            null
        }
    }
}