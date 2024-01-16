package com.intermodular.hotel.carrito.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.intermodular.hotel.carrito.ui.composables.*
import com.intermodular.hotel.composables.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarritoScreen(
    navController: NavController,
    carritoViewModel: CarritoViewModel
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = 15.dp)
            ) {
                Text1("Checkout")
            }
        }
    ) {
        carritoViewModel.generateSampleData()
        Column {
            Spacer(
                Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                val itemsTotalCost: Double? by carritoViewModel.itemsTotalCost.observeAsState()
                if (itemsTotalCost != null) {
                    Text(
                        text = "TOTAL: $itemsTotalCost EUROS",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
        val items: HashMap<String, HashMap<String, Int>>? by carritoViewModel.items.observeAsState()
        items?.let { Cart(it) }
    }
}

@Composable
fun Cart(superItems: HashMap<String, HashMap<String, Int>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 75.dp, start = 16.dp, end = 16.dp, bottom = 60.dp)
    ) {
        item {
            Spacer(
                Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
            for ((title, superItem) in superItems) {
                Box {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                CardFactura(superItem)
                Spacer(
                    Modifier
                        .width(16.dp)
                        .height(16.dp)
                )
            }
            Spacer(
                Modifier
                    .width(16.dp)
                    .height(80.dp)
            )
        }
    }
}
