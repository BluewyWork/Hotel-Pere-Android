package com.intermodular.hotel.reservationsOverview.domain

import com.intermodular.hotel.data.model.ReservationModel
import java.util.Date

class GetAllReservationsUseCase {
    suspend operator fun invoke(): List<ReservationModel> {
        return generateReservations() ?: emptyList()
    }

    private fun generateReservations(): ArrayList<ReservationModel>? {
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

        val reservation3 = ReservationModel(
            "Alice Johnson",
            "alice.johnson@email.com",
            303,
            180.0,
            Date(1644528000000), // Sample date: February 11, 2022, 12:00:00 AM UTC
            Date(1644787200000)  // Sample date: February 14, 2022, 12:00:00 AM UTC
        )

        val reservation4 = ReservationModel(
            "Bob Anderson",
            "bob.anderson@email.com",
            404,
            220.0,
            Date(1644883200000), // Sample date: February 15, 2022, 12:00:00 AM UTC
            Date(1645142400000)  // Sample date: February 18, 2022, 12:00:00 AM UTC
        )

        val reservation5 = ReservationModel(
            "Eva White",
            "eva.white@email.com",
            505,
            160.0,
            Date(1645238400000), // Sample date: February 19, 2022, 12:00:00 AM UTC
            Date(1645497600000)  // Sample date: February 22, 2022, 12:00:00 AM UTC
        )

        val reservation6 = ReservationModel(
            "Samuel Brown",
            "samuel.brown@email.com",
            606,
            190.0,
            Date(1645593600000), // Sample date: February 23, 2022, 12:00:00 AM UTC
            Date(1645852800000)  // Sample date: February 26, 2022, 12:00:00 AM UTC
        )

        val reservation7 = ReservationModel(
            "Mia Taylor",
            "mia.taylor@email.com",
            707,
            250.0,
            Date(1645948800000), // Sample date: February 27, 2022, 12:00:00 AM UTC
            Date(1646208000000)  // Sample date: March 2, 2022, 12:00:00 AM UTC
        )

        val reservation8 = ReservationModel(
            "William Harris",
            "william.harris@email.com",
            808,
            180.0,
            Date(1646304000000), // Sample date: March 3, 2022, 12:00:00 AM UTC
            Date(1646563200000)  // Sample date: March 6, 2022, 12:00:00 AM UTC
        )

        reservationList.add(reservation1)
        reservationList.add(reservation2)
        reservationList.add(reservation3)
        reservationList.add(reservation4)
        reservationList.add(reservation5)
        reservationList.add(reservation6)
        reservationList.add(reservation7)
        reservationList.add(reservation8)

        return reservationList
    }
}