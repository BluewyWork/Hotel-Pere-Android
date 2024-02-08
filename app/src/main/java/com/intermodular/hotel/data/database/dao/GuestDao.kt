package com.intermodular.hotel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intermodular.hotel.data.database.entities.GuestEntity

@Dao
interface GuestDao {
    @Query("SELECT * FROM customer_table ")
    fun getAuthenticatedGuest(): GuestEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(customer: GuestEntity)

    @Query("DELETE FROM customer_table")
    fun clearAll()
}