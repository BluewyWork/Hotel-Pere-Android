package com.intermodular.hotel.di

import com.intermodular.hotel.data.network.CustomerApiClient
import com.intermodular.hotel.data.network.RoomApiClient
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
    fun provideUserApiClient(retrofit: Retrofit): CustomerApiClient {
        return retrofit.create(CustomerApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomApiClient(retrofit: Retrofit): RoomApiClient {
        return retrofit.create(RoomApiClient::class.java)
    }
}