package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.ReservationModel
import com.intermodular.hotel.data.network.response.CustomResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ReservationApi {
    @GET(Endpoints.RETRIEVE_ALL_HOTEL_ROOMS)
    suspend fun getReservationListOfAuthenticatedGuest(): Response<ReservationModel>

    @POST(Endpoints.MAKE_RESERVATION)
    suspend fun makeReservation(reservation: ReservationModel): Response<CustomResponse>
}