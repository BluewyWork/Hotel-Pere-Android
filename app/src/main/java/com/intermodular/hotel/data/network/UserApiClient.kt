package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.CustomerModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiClient {
    @GET("/.json")//modificar segun endPoint
    suspend fun getUser(): Response<List<CustomerModel>>

    @POST("/.json")//modificar segun endPoint
    suspend fun insertOne(customerModel: CustomerModel)
}