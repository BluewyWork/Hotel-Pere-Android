package com.intermodular.hotel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intermodular.hotel.data.database.entities.CustomerEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ")
    fun getUser(): List<CustomerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<CustomerEntity>)

    @Query("DELETE FROM user_table")
    fun clearUser()
}