package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.MakeReservationModel
import com.intermodular.hotel.data.model.ReservationModel
import com.intermodular.hotel.data.network.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ReservationApi {
    @GET(Endpoints.RETRIEVE_ALL_RESERVATIONS)
    suspend fun getReservationListOfAuthenticatedGuest(
        @Header("Authorization") token: String
    ): ApiResponse<List<ReservationModel>>

    @POST(Endpoints.MAKE_RESERVATION)
    suspend fun makeReservation(
        @Header("Authorization") token: String,
        @Body makeReservationModel: MakeReservationModel
    ): ApiResponse<String>
}