package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.HotelRoomModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HotelRoomService @Inject constructor(
    private val api: RoomApiClient
) {
    suspend fun getHotelRoomList(): List<HotelRoomModel> {
        return withContext(Dispatchers.IO) {
            try {
                api.getHotelRoomList().body()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            emptyList()
        }
    }
}