package com.intermodular.hotel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.intermodular.hotel.data.database.dao.GuestDao
import com.intermodular.hotel.data.database.dao.ReservationDao
import com.intermodular.hotel.data.database.dao.TokenDao
import com.intermodular.hotel.data.database.entities.GuestEntity
import com.intermodular.hotel.data.database.entities.ReservationEntity
import com.intermodular.hotel.data.database.entities.TokenEntity

@Database(entities = [GuestEntity::class, ReservationEntity::class, TokenEntity::class], version = 1)
abstract class HotelDatabase : RoomDatabase() {
    abstract fun getGuestDao(): GuestDao
    abstract fun getReservationDao(): ReservationDao
    abstract fun getTokenDao(): TokenDao
}