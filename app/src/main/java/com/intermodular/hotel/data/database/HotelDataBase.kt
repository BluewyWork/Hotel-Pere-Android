package com.intermodular.hotel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.intermodular.hotel.data.database.dao.UserDao
import com.intermodular.hotel.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)//dentro del corchete van todas las
// entidades que necesitemos crear
abstract class HotelDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao//cada objeto Dao es una abstract fun
}