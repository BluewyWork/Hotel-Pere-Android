package com.intermodular.hotel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intermodular.hotel.data.database.entities.CustomerEntity

@Dao
interface CustomerDao {
    @Query("SELECT * FROM user_table ")
    fun getCustomer(): CustomerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: CustomerEntity)

    @Query("DELETE FROM user_table")
    fun clearCustomer()
}