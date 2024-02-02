package com.intermodular.hotel.reservationsOverview.domain

import com.intermodular.hotel.data.model.ReservationModel
import java.util.Date

class GetAllReservationsUseCase {
    suspend operator fun invoke(): List<ReservationModel> {
        return generateReservations() ?: emptyList()
    }

    fun generateReservations(): ArrayList<ReservationModel>? {
        val reservationList = ArrayList<ReservationModel>()

        val reservation1 = ReservationModel(
            "John Doe",
            "john.doe@email.com",
            101,
            150.0,
            Date(1643750400000), // Sample date: January 31, 2022, 12:00:00 AM UTC
            Date(1644086400000)  // Sample date: February 6, 2022, 12:00:00 AM UTC
        )

        val reservation2 = ReservationModel(
            "Jane Smith",
            "jane.smith@email.com",
            202,
            200.0,
            Date(1644172800000), // Sample date: February 7, 2022, 12:00:00 AM UTC
            Date(1644432000000)  // Sample date: February 10, 2022, 12:00:00 AM UTC
        )

        // Add more reservations as needed...

        reservationList.add(reservation1)
        reservationList.add(reservation2)

        return reservationList
    }
}