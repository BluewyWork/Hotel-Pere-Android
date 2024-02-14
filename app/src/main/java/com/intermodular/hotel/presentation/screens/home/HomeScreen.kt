package com.intermodular.hotel.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.presentation.composables.BottomBar
import com.intermodular.hotel.presentation.screens.home.composables.HotelRoomCard

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    Scaffold(bottomBar = { BottomBar(navController) }) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
        ) {
            Home(homeViewModel, navController)
        }
    }
}

@Composable
fun Home(homeViewModel: HomeViewModel, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 0.dp)
    ) {
        item {
            LoadHotelCards(homeViewModel, navController)
        }
    }
}

@Composable
fun LoadHotelCards(homeViewModel: HomeViewModel, navController: NavController) {
    val hotelRoomList: List<HotelRoom>? by homeViewModel.hotelRooms.observeAsState()

    hotelRoomList?.forEach { room ->
        HotelRoomCard(
            image = room.image,
            roomNumber = room.number,
            numberOfBeds = room.numberOfBeds,
            pricePerNight = room.pricePerNight
        ) {
            navController.navigate(Destinations.Details.route + "/${room.number}")
        }
    }
}
