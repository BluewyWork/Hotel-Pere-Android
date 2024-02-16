package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.GuestModel
import com.intermodular.hotel.data.network.response.ApiResponse
import com.intermodular.hotel.data.network.response.CustomResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface GuestApi {
    @GET(Endpoints.RETRIEVE_GUEST)
    suspend fun retrieveGuest(@Header("Authorization") token: String): ApiResponse<GuestModel>

    @POST(Endpoints.REGISTER_GUEST)
    suspend fun registerGuest(@Body guest: GuestModel): Response<CustomResponse>
}