package com.intermodular.hotel.data.database.dao

import androidx.room.Query
import com.intermodular.hotel.data.database.entities.ReservationEntity

interface ReservationDao {
    @Query("SELECT * FROM reservation_table")
    fun getReservationListOfAuthenticatedCustomer(): List<ReservationEntity>
}