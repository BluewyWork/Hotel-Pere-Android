package com.intermodular.hotel.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}