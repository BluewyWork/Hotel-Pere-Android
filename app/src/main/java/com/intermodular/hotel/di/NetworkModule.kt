package com.intermodular.hotel.di

import com.intermodular.hotel.data.network.GuestApi
import com.intermodular.hotel.data.network.HotelRoomApi
import com.intermodular.hotel.data.network.ReservationApi
import com.intermodular.hotel.data.network.TokenApi
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
        return Retrofit.Builder().baseUrl("http://10.0.2.2:8000")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideGuestApiClient(retrofit: Retrofit): GuestApi {
        return retrofit.create(GuestApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomApiClient(retrofit: Retrofit): HotelRoomApi {
        return retrofit.create(HotelRoomApi::class.java)
    }

    @Singleton
    @Provides
    fun provideReserationApiClient(retrofit: Retrofit): ReservationApi {
        return retrofit.create(ReservationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTokenApiClient(retrofit: Retrofit): TokenApi {
        return retrofit.create(TokenApi::class.java)
    }
}