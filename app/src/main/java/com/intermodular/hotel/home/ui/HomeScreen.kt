package com.intermodular.hotel.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.composables.BottomBar
import com.intermodular.hotel.home.ui.composables.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomBar(navController) }) {
        Home()
    }
}

@Composable
fun Home() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 60.dp)
    ) {
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                item {
                    HotelCard()
                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                    )
                    HotelCard()
                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                    )
                    HotelCard()
                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                    )
                    HotelCard()
                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                    )
                }
            }
            HotelCard()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
            HotelCard()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
            HotelCard()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
            HotelCard()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(100.dp)
                )
            }
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { }
            )
        },
        title = { Text("") },
        modifier = Modifier
            .height(50.dp)
    )
}
