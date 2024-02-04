package com.intermodular.hotel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.intermodular.hotel.data.database.dao.CustomerDao
import com.intermodular.hotel.data.database.dao.ReservationDao
import com.intermodular.hotel.data.database.entities.CustomerEntity
import com.intermodular.hotel.data.database.entities.ReservationEntity

@Database(entities = [CustomerEntity::class, ReservationEntity::class], version = 1)
abstract class HotelDatabase : RoomDatabase() {
    abstract fun getCustomerDao(): CustomerDao
    abstract fun getReservationDao(): ReservationDao
}