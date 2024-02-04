package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.ReservationDao
import com.intermodular.hotel.data.database.entities.ReservationEntity
import com.intermodular.hotel.data.network.ReservationService
import com.intermodular.hotel.domain.model.Reservation
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject

class ReservationRepository @Inject constructor(
    private val api: ReservationService,
    private val reservationDao: ReservationDao
) {
    suspend fun getReservationListOfAuthenticatedCustomerFromApi(): List<Reservation> {
        return api.getReservationListOfAuthenticatedCustomer().map { it.toDomain() }
    }

    suspend fun getReservationListOfAuthenticatedCustomerFromDatabase(): List<Reservation> {
        return reservationDao.getReservationListOfAuthenticatedCustomer().map { it.toDomain() }
    }

    suspend fun insertOneReservationOfAuthenticatedCustomer(reservation: ReservationEntity) {
        reservationDao.insertOne(reservation)
    }

    suspend fun clearReservationListOfAuthenticatedCustomer() {
        reservationDao.clearAll()
    }
}