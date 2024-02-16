package com.intermodular.hotel.presentation.composables

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LineStyle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.core.navigations.Destinations

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier
            .height(50.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(Destinations.Home.route) },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                )
            }
        )
        NavigationBarItem(
            selected = false,
            //Hay que cambiarlo
            onClick = { navController.navigate(Destinations.Details.route) },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search"
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(Destinations.ReservationsOverview.route) },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.LineStyle,
                    contentDescription = "Cart",
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(Destinations.CheckChange.route) },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "Cart",
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                if (false) {
                    // if user not logged in redirect to login screen
                    //
                } else {
                    navController.navigate(Destinations.Profile.route)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Person",
                )
            }
        )
    }
}
