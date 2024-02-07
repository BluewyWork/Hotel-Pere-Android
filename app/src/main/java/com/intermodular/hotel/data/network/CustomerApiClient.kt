package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.CustomerModel
import com.intermodular.hotel.data.model.LoginModel
import com.intermodular.hotel.data.network.response.CustomResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CustomerApiClient {
    @GET("/.json")
    suspend fun getOneCustomer(): Response<CustomerModel>

    @POST("/.json")
    suspend fun insertOneCustomer(customerModel: CustomerModel)

    @POST("/auth/client/login")
    suspend fun loginCustomer(@Body loginModel: LoginModel): Response<CustomResponse>
}