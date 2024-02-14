package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.HotelRoomModel
import com.intermodular.hotel.data.network.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HotelRoomApi {
    @GET(Endpoints.RETRIEVE_ALL_HOTEL_ROOMS)
    suspend fun getHotelRoomList(): ApiResponse<List<HotelRoomModel>>

    @GET(Endpoints.RETRIEVE_ONE_HOTEL_ROOM)
    suspend fun getOneHotelRoom(@Path("roomNumber") number: Int): ApiResponse<HotelRoomModel>
}

