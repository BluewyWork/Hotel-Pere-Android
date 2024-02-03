package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.HotelRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface RoomApiClient {
    @GET("null")
    suspend fun getHotelRoomList(): Response<List<HotelRoomModel>>
}