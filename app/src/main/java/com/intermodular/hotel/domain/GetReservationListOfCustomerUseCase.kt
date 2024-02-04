package com.intermodular.hotel.domain

import com.intermodular.hotel.data.ReservationRepository
import com.intermodular.hotel.domain.model.Reservation
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class GetReservationListOfCustomerUseCase @Inject constructor(
    private val api: ReservationRepository
) {
    suspend operator fun invoke(): List<Reservation> {
        val reservationsFromApi = api.getReservationListOfAuthenticatedCustomerFromApi()

        return if (reservationsFromApi.isNotEmpty()) {
            api.clearReservationListOfAuthenticatedCustomer()

            for (reservation in reservationsFromApi) {
                api.insertReservationOfAuthenticatedCustomer(reservation)
            }

            reservationsFromApi
        } else {
            val reservationsFromDatabase =
                api.getReservationListOfAuthenticatedCustomerFromDatabase()

            if (reservationsFromDatabase.isNotEmpty()) {
                return reservationsFromDatabase
            }

            generateReservations()
        }
    }

    private fun generateReservations(): List<Reservation> {
        val reservations = mutableListOf<Reservation>()

        val currentDate = Date()

        for (i in 1..10) {
            val randomDays = (1..10).random()
            val checkInDate = Calendar.getInstance()
            checkInDate.time = currentDate
            checkInDate.add(Calendar.DAY_OF_YEAR, randomDays)

            val randomStay = (2..7).random()
            val checkOutDate = Calendar.getInstance()
            checkOutDate.time = checkInDate.time
            checkOutDate.add(Calendar.DAY_OF_YEAR, randomStay)

            val reservation = Reservation(
                "Customer$i",
                "Surname$i",
                "customer$i@example.com",
                (101 + i),
                100.0,
                checkInDate.time,
                checkOutDate.time,
                true
            )

            reservations.add(reservation)
        }

        return reservations
    }
}