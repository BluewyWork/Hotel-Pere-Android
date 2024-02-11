package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.network.response.GuestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface GuestApi {
    @GET(Endpoints.RETRIEVE_GUEST)
    suspend fun getOneGuest(@Header("Authorization") token: String): Response<GuestResponse>
}