package com.intermodular.hotel.data.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intermodular.hotel.data.database.entities.ReservationEntity

interface ReservationDao {
    @Query("SELECT * FROM reservation_table")
    fun getReservationListOfAuthenticatedCustomer(): List<ReservationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(reservation: ReservationEntity)

    @Query("DELETE FROM reservation_table")
    fun clearAll()
}