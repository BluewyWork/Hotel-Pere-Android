package com.intermodular.hotel.presentation.screens.hotelRoomDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.intermodular.hotel.R
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.presentation.composables.BottomBar
import com.intermodular.hotel.ui.theme.turquesaPrincipal

@Composable
fun HotelRoomDetails(
    navController: NavController,
    hotelRoomDetailsViewModel: HotelRoomDetailsViewModel
) {
    Scaffold(bottomBar = { BottomBar(navController) }) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
        ) {
            HotelRoomDetails(hotelRoomDetailsViewModel, navController)
        }
    }
}

@Composable
fun HotelRoomDetails(
    hotelRoomDetailsViewModel: HotelRoomDetailsViewModel,
    navController: NavController
) {
    val hotelRoom: HotelRoom? by hotelRoomDetailsViewModel.hotelRoom.observeAsState()

    if (hotelRoom == null) {
        return
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription = "Sample",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "${hotelRoom!!.number}")

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Habitación Standard",
                Modifier.padding(start = 16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = hotelRoom!!.description,
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = "Camas",
                    Modifier.padding(start = 16.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(text = "2", Modifier.padding(start = 16.dp), fontSize = 25.sp)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = "Wifi",
                    Modifier.padding(start = 16.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Si", Modifier.padding(start = 16.dp), fontSize = 25.sp)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = "Servicio",
                    Modifier.padding(start = 16.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(text = "Si", Modifier.padding(start = 16.dp), fontSize = 25.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "200€/noche",
                Modifier.padding(start = 16.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            val isLoggedIn: Boolean by hotelRoomDetailsViewModel.isLoggedIn.observeAsState(initial = false)

            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(turquesaPrincipal),
                onClick = {
                    hotelRoomDetailsViewModel.onReservePress()

                    if (!isLoggedIn) {
                        navController.navigate("login")
                    }
                }
            ) {
                Text(text = "Reservar")
            }
        }
    }
}

