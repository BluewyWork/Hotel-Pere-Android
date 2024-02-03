package com.intermodular.hotel.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.presentation.composables.BottomBar
import com.intermodular.hotel.presentation.screens.home.composables.HotelCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    Scaffold(bottomBar = { BottomBar(navController) }) {
        Home(homeViewModel)
    }
}

@Composable
fun Home(homeViewModel: HomeViewModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 66.dp)
    ) {
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp, start = 4.dp, end = 4.dp, bottom = 16.dp)
            ) {
                item {
                    GenerateHotelCards(homeViewModel)
                }
            }
            GenerateHotelCards(homeViewModel)
        }
    }
}

@Composable
fun GenerateHotelCards(homeViewModel: HomeViewModel) {
    val hotelHotelRooms: List<HotelRoom>? by homeViewModel.hotelRooms.observeAsState()
    if (!hotelHotelRooms.isNullOrEmpty()) {
        for (i in hotelHotelRooms!!) {
            HotelCard()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
        }
    }
}
