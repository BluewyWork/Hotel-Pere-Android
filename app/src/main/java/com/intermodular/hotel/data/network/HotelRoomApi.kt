package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.HotelRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface HotelRoomApi {
    @GET(Endpoints.RETRIEVE_ALL_HOTEL_ROOMS)
    suspend fun getHotelRoomList(): Response<List<HotelRoomModel>>

    @GET(Endpoints.RETRIEVE_ONE_HOTEL_ROOM)
    suspend fun getOneHotelRoom(roomNumber: Int): Response<HotelRoomModel>
}