package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.ReservationModel
import retrofit2.Response
import retrofit2.http.GET

interface ReservationApiClient {
    @GET("/path")
    suspend fun getReservationListOfCustomer(): Response<ReservationModel>
}