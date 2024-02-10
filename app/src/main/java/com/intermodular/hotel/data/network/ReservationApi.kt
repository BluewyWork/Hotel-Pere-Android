package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.ReservationModel
import com.intermodular.hotel.data.network.response.CustomResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ReservationApi {
    @GET("/path")
    suspend fun getReservationListOfAuthenticatedGuest(): Response<ReservationModel>

    @POST("/replace_with_actual_endpoint")
    suspend fun makeReservation(reservation: ReservationModel): Response<CustomResponse>
}