package com.intermodular.hotel.carrito.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarritoScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomBar()
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
        var superItems: HashMap<String, HashMap<String, Int>> = HashMap()
        var items: HashMap<String, Int> = HashMap()
        items["Habitacion 1"] = 50
        items["Habitacion 2"] = 150
        items["Habitacion 3"] = 250
        items["Habitacion 4"] = 350
        items["Habitacion 5"] = 450
        superItems["Set 1"] = items

        var items2: HashMap<String, Int> = HashMap()
        items2["Habitacion 1"] = 50
        items2["Habitacion 2"] = 150
        items2["Habitacion 3"] = 250
        items2["Habitacion 4"] = 350
        items2["Habitacion 5"] = 450

        var items3: HashMap<String, Int> = HashMap()
        items3["Habitacion 1"] = 50
        items3["Habitacion 2"] = 150
        items3["Habitacion 3"] = 250
        items3["Habitacion 4"] = 350
        items3["Habitacion 5"] = 450

        superItems["Set 2"] = items2
        superItems["Set 3"] = items3

        var totalCost = 0
        for ((setKey, itemsMini) in superItems) {
            var subtotal = 0

            for ((_, value) in itemsMini) {
                subtotal += value
            }

            totalCost += subtotal
        }

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Text(
                    text = "TOTAL: $totalCost EUROS",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }

        }
        Cart(superItems)
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
                BillItem(superItem)
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

@Composable
fun BottomBar() {
    NavigationBar(
        modifier = Modifier
            .height(50.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search"
                )
            }
        )
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "Cart",
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Person",
                )
            }
        )
    }
}

@Composable
fun BillItem(items: HashMap<String, Int>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            var totalCost = 0
            for ((itemName, cost) in items) {
                totalCost += cost
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text1(text = itemName)
                    Text1(text = "$cost EUROS")
                }
                Divider(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text1(text = "SUBTOTAL:")
                Text1(text = "$totalCost Euros")
            }
        }
    }
}

@Composable
fun BuyButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
    ) {
        Text(text = "CHECKOUT")
    }
}

@Composable
fun Text1(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}