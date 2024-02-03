package com.intermodular.hotel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.intermodular.hotel.data.database.dao.CustomerDao
import com.intermodular.hotel.data.database.entities.CustomerEntity

@Database(entities = [CustomerEntity::class], version = 1)//dentro del corchete van todas las
// entidades que necesitemos crear
abstract class HotelDatabase : RoomDatabase() {
    abstract fun getUserDao(): CustomerDao//cada objeto Dao es una abstract fun
}