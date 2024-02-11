package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.HotelRoomModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HotelRoomApi {
    @GET(Endpoints.RETRIEVE_ALL_HOTEL_ROOMS)
    suspend fun getHotelRoomList(): ApiResponse<List<HotelRoomModel>>

    @GET("/auth/client/{number}")
    suspend fun getOneHotelRoom(@Path("number")number: Int): HotelRoomModel
}

data class ApiResponse<T>(val data: T)