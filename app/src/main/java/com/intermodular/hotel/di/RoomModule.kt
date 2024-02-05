package com.intermodular.hotel.di

import android.content.Context
import androidx.room.Room
import com.intermodular.hotel.data.database.HotelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val HOTEL_DATABASE_NAME = "HotelDatabase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, HotelDatabase::class.java, HOTEL_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideCustomerDao(db: HotelDatabase) = db.getCustomerDao()

    @Singleton
    @Provides
    fun provideReservationDao(db: HotelDatabase) = db.getReservationDao()
}