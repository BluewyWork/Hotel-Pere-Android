package com.abelgarciavicario.intermodularhotel.log.network

import com.abelgarciavicario.intermodularhotel.log.network.dto.UserRegistroDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RegistroClient {
    @Headers(
        "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNsdXRydHFjZWVyZ2FmZHRxamViIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDAwNTI2MDksImV4cCI6MjAxNTYyODYwOX0.M0LOr8aHu4GA8TE9B-7skWZl348m2YF1ACUX_CZQcBw",
        "Content-Type: application/json")
    @GET
        ("auth/v1/signup")
    suspend fun doRegistro(@Body user: UserRegistroDTO): Response<UserResponse>
}