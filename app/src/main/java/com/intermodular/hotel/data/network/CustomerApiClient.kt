package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.CustomerModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface CustomerApiClient {
    @GET("/.json")//modificar segun endPoint
    suspend fun getOneCustomer(): Response<CustomerModel>

    @POST("/.json")//modificar segun endPoint
    suspend fun insertOneCustomer(customerModel: CustomerModel)
}