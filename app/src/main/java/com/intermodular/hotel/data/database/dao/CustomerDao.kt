package com.intermodular.hotel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intermodular.hotel.data.database.entities.CustomerEntity

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer_table ")
    fun getAuthenticatedCustomer(): CustomerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(customer: CustomerEntity)

    @Query("DELETE FROM customer_table")
    fun clearAll()
}