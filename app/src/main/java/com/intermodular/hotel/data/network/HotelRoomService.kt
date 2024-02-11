package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.HotelRoomModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class HotelRoomService @Inject constructor(
    private val hotelRoomApi: HotelRoomApi
) {
    suspend fun  getHotelRoomListFromApi(): List<HotelRoomModel> {
        return withContext(Dispatchers.IO) {
            val response =hotelRoomApi.getHotelRoomList().data
            response
        }
    }

    /*suspend fun getOneHotelRoomFromApi(roomNumber: Int): HotelRoomModel {
        return withContext(Dispatchers.IO) {
            val response = hotelRoomApi.getOneHotelRoom(roomNumber)
            response
        }
    }*/
}