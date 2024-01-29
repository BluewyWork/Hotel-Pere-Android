package com.intermodular.hotel.di

import android.content.Context
import androidx.room.Room
import com.intermodular.hotel.data.database.HotelDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val HOTEL_DATABASE_NAME = "HotelDataBase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, HotelDataBase::class.java, HOTEL_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(db:HotelDataBase) = db.getUserDao()

    /*@Singleton
    @Provides
    fun provideRoomDao(db:HotelDataBase) = db.getRoomDao()*/
}