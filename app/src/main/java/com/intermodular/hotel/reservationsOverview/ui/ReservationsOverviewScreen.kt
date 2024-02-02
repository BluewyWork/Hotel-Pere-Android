package com.intermodular.hotel.reservationsOverview.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.intermodular.hotel.data.model.ReservationModel
import com.intermodular.hotel.reservationsOverview.ui.composables.ReservationCard

@Composable
fun ReservationsOverviewScreen(
    reservationsOverviewViewModel: ReservationsOverviewViewModel,
    navController: NavController
) {
    ReservationsOverview(reservationsOverviewViewModel)
}

@Composable
fun ReservationsOverview(reservationsOverviewViewModel: ReservationsOverviewViewModel) {
    Reservations(reservationsOverviewViewModel)
}

@Composable
fun Reservations(reservationsOverviewViewModel: ReservationsOverviewViewModel) {
    val reservations: List<ReservationModel>? by reservationsOverviewViewModel.reservations.observeAsState()

    if (reservations.isNullOrEmpty()) {
        return
    }

    LazyColumn() {
        item {
            for (reservation in reservations!!) {
                ReservationCard(
                    customerName = reservation.customerName,
                    customerEmail = reservation.customerEmail,
                    roomNumber = reservation.roomNumber,
                    pricePerNight = reservation.pricePerNight,
                    checkIn = reservation.checkIn,
                    checkOut = reservation.checkOut
                )
            }
        }
    }
}