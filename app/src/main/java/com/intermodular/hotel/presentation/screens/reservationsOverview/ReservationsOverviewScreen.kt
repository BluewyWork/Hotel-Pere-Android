package com.intermodular.hotel.presentation.screens.reservationsOverview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.domain.model.Reservation
import com.intermodular.hotel.presentation.composables.BottomBar
import com.intermodular.hotel.presentation.screens.reservationsOverview.composables.ReservationCard

@Composable
fun ReservationsOverviewScreen(
    reservationsOverviewViewModel: ReservationsOverviewViewModel,
    navController: NavController
) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        Column(
            Modifier.padding(innerPadding)
        ) {
            ReservationsOverview(reservationsOverviewViewModel)
        }
    }
}

@Composable
fun ReservationsOverview(reservationsOverviewViewModel: ReservationsOverviewViewModel) {
    Reservations(reservationsOverviewViewModel)
}

@Composable
fun Reservations(reservationsOverviewViewModel: ReservationsOverviewViewModel) {
    val reservations: List<Reservation>? by reservationsOverviewViewModel.reservations.observeAsState()

    if (reservations.isNullOrEmpty()) {
        return
    }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 0.dp)
    ) {
        item {
            for (reservation in reservations!!) {
                ReservationCard(
                    customerName = reservation.guestName,
                    customerEmail = reservation.guestEmail,
                    roomNumber = reservation.roomNumber,
                    pricePerNight = reservation.pricePerNight,
                    checkIn = reservation.checkIn,
                    checkOut = reservation.checkOut
                )
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}