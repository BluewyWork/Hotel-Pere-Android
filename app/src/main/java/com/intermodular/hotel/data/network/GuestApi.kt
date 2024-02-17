package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.GuestModel
import com.intermodular.hotel.data.model.GuestPlusPasswordModel
import com.intermodular.hotel.data.network.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface GuestApi {
    @GET(Endpoints.RETRIEVE_GUEST)
    suspend fun retrieveGuest(@Header("Authorization") token: String): ApiResponse<GuestModel>

    @POST(Endpoints.REGISTER_GUEST)
    suspend fun registerGuest(@Body guest: GuestPlusPasswordModel): ApiResponse<String>

    @POST(Endpoints.UPDATE_GUEST)
    suspend fun updateGuest(
        @Header("Authorization") token: String,
        @Body guest: GuestModel
    ): ApiResponse<String>

    @DELETE(Endpoints.DELETE_GUEST)
    suspend fun deleteGuest(
        @Header("Authorization") token: String
    ): ApiResponse<String>
}