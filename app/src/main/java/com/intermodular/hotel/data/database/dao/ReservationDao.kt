package com.intermodular.hotel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intermodular.hotel.data.database.entities.ReservationEntity

@Dao
interface ReservationDao {
    @Query("SELECT * FROM reservation_table")
    fun getReservationListOfAuthenticatedGuest(): List<ReservationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(reservation: ReservationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(reservations: List<ReservationEntity>)

    @Query("DELETE FROM reservation_table")
    fun clearAll()
}