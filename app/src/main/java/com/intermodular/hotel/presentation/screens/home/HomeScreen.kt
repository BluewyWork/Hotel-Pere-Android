package com.intermodular.hotel.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
            GenerateHotelCards(homeViewModel, navController)
        }
    }
}

@Composable
fun GenerateHotelCards(homeViewModel: HomeViewModel, navController: NavController) {
    val hotelHotelRooms: List<HotelRoom>? by homeViewModel.hotelRooms.observeAsState()
    if (!hotelHotelRooms.isNullOrEmpty()) {
        for (room in hotelHotelRooms!!) {
            HotelRoomCard(
                navController = navController,
                room,
                homeViewModel
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
        }
    }
}
