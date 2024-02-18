package com.intermodular.hotel.data

import android.util.Log
import com.intermodular.hotel.data.database.dao.ReservationDao
import com.intermodular.hotel.data.database.entities.ReservationEntity
import com.intermodular.hotel.data.model.MakeReservationModel
import com.intermodular.hotel.data.model.ReservationDates
import com.intermodular.hotel.data.network.ReservationService
import com.intermodular.hotel.domain.model.Reservation
import com.intermodular.hotel.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

class ReservationRepository @Inject constructor(
    private val api: ReservationService,
    private val reservationDao: ReservationDao
) {
    suspend fun getReservationListOfAuthenticatedGuestFromApi(): List<Reservation> {
        return try {
            api.getReservationListOfAuthenticatedGuestFromApi().map { it.toDomain() }
        } catch (e: Exception) {
            Log.e("LOOK AT ME", "ERROR: ${e.message}")
            emptyList()
        }
    }

    suspend fun getReservationListOfAuthenticatedGuestFromDatabase(): List<Reservation> {
        try {
            return withContext(Dispatchers.IO) {
                reservationDao.getReservationListOfAuthenticatedGuest().map { it.toDomain() }
            }
        } catch (e: Exception) {
            Log.e("LOOK AT ME", "${e.message}")
        }
        return emptyList()
    }

    suspend fun insertOneReservationOfAuthenticatedGuest(reservation: ReservationEntity) {
        reservationDao.insertOne(reservation)
    }

    suspend fun insertReservationListOfAuthenticatedGuest(reservations: List<ReservationEntity>) {
        reservationDao.insertMany(reservations)
    }

    suspend fun clearReservationListOfAuthenticatedGuest() {
        reservationDao.clearAll()
    }

    suspend fun makeReservation(
        tokenFromGuest: String,
        roomNumber: Int,
        checkIn: LocalDate,
        checkOut: LocalDate
    ): Boolean {
        val makeReservationModel = MakeReservationModel(
            roomNumber = roomNumber,
            checkIn = checkIn.toString(),
            checkOut = checkOut.toString()
        )

        return api.makeReservation(tokenFromGuest, makeReservationModel)
    }
}