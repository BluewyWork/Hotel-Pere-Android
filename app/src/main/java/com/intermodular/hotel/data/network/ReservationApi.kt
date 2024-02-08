package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.ReservationModel
import retrofit2.Response
import retrofit2.http.GET

interface ReservationApi {
    @GET("/path")
    suspend fun getReservationListOfAuthenticatedGuest(): Response<ReservationModel>
}