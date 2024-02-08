package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.GuestModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface GuestApi {
    @GET("/.json")
    suspend fun getOneGuest(@Header("Authorization") token: String): Response<GuestModel>
}