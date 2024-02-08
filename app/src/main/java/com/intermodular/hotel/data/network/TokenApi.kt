package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.LoginModel
import com.intermodular.hotel.data.network.response.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenApi {
    @POST("/auth/client/login")
    suspend fun getGuestToken(@Body loginModel: LoginModel): Response<TokenResponse>
}