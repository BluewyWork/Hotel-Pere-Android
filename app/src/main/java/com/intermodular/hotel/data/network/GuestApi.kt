package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.GuestModel
import com.intermodular.hotel.data.network.response.CustomResponse
import com.intermodular.hotel.data.network.response.GuestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface GuestApi {
    @GET(Endpoints.RETRIEVE_GUEST)
    suspend fun retrieveGuest(@Header("Authorization") token: String): Response<GuestResponse>

    @POST(Endpoints.REGISTER_GUEST)
    suspend fun registerGuest(guest: GuestModel): Response<CustomResponse>
}