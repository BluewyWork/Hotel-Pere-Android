package com.intermodular.hotel.presentation.screens.hotelRoomDetails

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.presentation.composables.BottomBar
import com.intermodular.hotel.presentation.screens.hotelRoomDetails.composables.DatePickerWithDialog
import com.intermodular.hotel.ui.theme.turquesaPrincipal
import java.time.LocalDate

@Composable
fun HotelRoomDetailsScreen(
    navController: NavController,
    hotelRoomDetailsViewModel: HotelRoomDetailsViewModel
) {
    Scaffold(bottomBar = { BottomBar(navController) }) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
        ) {
            HotelRoomDetailsScreen(hotelRoomDetailsViewModel, navController)
        }
    }
}

@Composable
fun HotelRoomDetailsScreen(
    hotelRoomDetailsViewModel: HotelRoomDetailsViewModel,
    navController: NavController
) {
    val currentHotelRoom: HotelRoom? by hotelRoomDetailsViewModel.hotelRoom.observeAsState()

    currentHotelRoom ?: run {
        Text("unable to load...")
    }

    currentHotelRoom?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(top = 20.dp, bottom = 20.dp)
        ) {
            item {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    model = it.image,
                    contentDescription = null,
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = it.description,
                    Modifier.padding(start = 16.dp, end = 16.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
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

                    Text(
                        text = it.numberOfBeds.toString(),
                        Modifier.padding(start = 16.dp),
                        fontSize = 25.sp
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = it.pricePerNight.toString() + "€/noche",
                    Modifier.padding(start = 16.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(80.dp))

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                    colors = ButtonDefaults.buttonColors(turquesaPrincipal),
                    onClick = {
                        hotelRoomDetailsViewModel.onReservePress(navController)
                    }
                ) {
                    Text(text = "Reservar")
                }

                val checkIn: LocalDate? by hotelRoomDetailsViewModel.checkIn.observeAsState()
                val checkOut: LocalDate? by hotelRoomDetailsViewModel.checkOut.observeAsState()

                DatePickerWithDialog(
                    value = checkIn,
                    dateFormatter = { date ->
                        date.toString()
                    },
                    onChange = { date ->
                        hotelRoomDetailsViewModel.onCheckInChange(date!!)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                DatePickerWithDialog(
                    value = checkOut,
                    dateFormatter = { date ->
                        date.toString()
                    },
                    onChange = { date ->
                        hotelRoomDetailsViewModel.onCheckOutChange(date!!)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

