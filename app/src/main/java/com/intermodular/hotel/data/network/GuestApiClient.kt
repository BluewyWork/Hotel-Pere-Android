package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.GuestModel
import com.intermodular.hotel.data.model.LoginModel
import com.intermodular.hotel.data.network.response.CustomResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GuestApiClient {
    @GET("/.json")
    suspend fun getOneGuest(): Response<GuestModel>

    @POST("/auth/client/login")
    suspend fun loginGuest(@Body loginModel: LoginModel): Response<CustomResponse>
}