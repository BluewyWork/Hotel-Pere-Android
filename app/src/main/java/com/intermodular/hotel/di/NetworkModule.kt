package com.intermodular.hotel.di

import com.intermodular.hotel.data.network.CustomerApiClient
import com.intermodular.hotel.data.network.HotelRoomApiClient
import com.intermodular.hotel.data.network.ReservationApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://localhost:8000")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideCustomerApiClient(retrofit: Retrofit): CustomerApiClient {
        return retrofit.create(CustomerApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomApiClient(retrofit: Retrofit): HotelRoomApiClient {
        return retrofit.create(HotelRoomApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideReserationApiClient(retrofit: Retrofit): ReservationApiClient {
        return retrofit.create(ReservationApiClient::class.java)
    }
}