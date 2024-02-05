package com.intermodular.hotel.data

import android.util.Log
import com.intermodular.hotel.data.database.dao.ReservationDao
import com.intermodular.hotel.data.database.entities.ReservationEntity
import com.intermodular.hotel.data.network.ReservationService
import com.intermodular.hotel.domain.model.Reservation
import com.intermodular.hotel.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReservationRepository @Inject constructor(
    private val api: ReservationService,
    private val reservationDao: ReservationDao
) {
    suspend fun getReservationListOfAuthenticatedCustomerFromApi(): List<Reservation> {
        return api.getReservationListOfAuthenticatedCustomer().map { it.toDomain() }
    }

    suspend fun getReservationListOfAuthenticatedCustomerFromDatabase(): List<Reservation> {
        try {
            return withContext(Dispatchers.IO) {
                api.getReservationListOfAuthenticatedCustomer().map { it.toDomain() }
            }
        } catch(e: Exception) {
            Log.e("LOOK AT ME", "${e.message}")
        }
        return emptyList()
    }

    suspend fun insertOneReservationOfAuthenticatedCustomer(reservation: ReservationEntity) {
        reservationDao.insertOne(reservation)
    }

    suspend fun clearReservationListOfAuthenticatedCustomer() {
        reservationDao.clearAll()
    }
}