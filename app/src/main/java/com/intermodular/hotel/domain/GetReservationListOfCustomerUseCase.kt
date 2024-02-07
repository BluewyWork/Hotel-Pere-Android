package com.intermodular.hotel.domain

import com.intermodular.hotel.data.ReservationRepository
import com.intermodular.hotel.domain.model.Reservation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import kotlin.random.Random

class GetReservationListOfCustomerUseCase @Inject constructor(
    private val api: ReservationRepository
) {
    suspend operator fun invoke(): List<Reservation> {
        val reservationsFromApi = api.getReservationListOfAuthenticatedCustomerFromApi()

        return if (reservationsFromApi.isNotEmpty()) {
            api.clearReservationListOfAuthenticatedCustomer()

            // unable to convert toDatabase ???????
            TODO()

            reservationsFromApi
        } else {
            val reservationsFromDatabase =
                api.getReservationListOfAuthenticatedCustomerFromDatabase()

            if (reservationsFromDatabase.isNotEmpty()) {
                return reservationsFromDatabase
            }

            generateRandomReservations()
        }
    }

    fun generateRandomReservations(): List<Reservation> {
        val reservations = mutableListOf<Reservation>()

        val roomCount = 10
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        for (i in 1..roomCount) {
            val customerName = "Customer$i"
            val customerSurname = "Surname$i"
            val customerEmail = "customer$i@example.com"
            val roomNumber = i
            val pricePerNight = Random.nextDouble(50.0, 200.0)
            val checkIn = LocalDateTime.now().plusDays(Random.nextLong(1, 10))
            val checkOut = checkIn.plusDays(Random.nextLong(1, 10))
            val reserved = Random.nextBoolean()

            val reservation = Reservation(
                customerName,
                customerSurname,
                customerEmail,
                roomNumber,
                pricePerNight,
                checkIn,
                checkOut,
                reserved
            )

            reservations.add(reservation)
        }

        return reservations
    }
}