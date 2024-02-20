package com.intermodular.hotel.presentation.screens.reservationsOverview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.intermodular.hotel.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = "No tienes reservas. Haz una ahora!",
                    style = TextStyle(color = Color.Black, fontSize = 20.sp)
                )
                Image(
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .padding(16.dp).align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.reservations),
                    contentDescription = "No reservations"
                )
            }
        }
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
                    customerEmail = reservation.guestEmail ,
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