package com.abelgarciavicario.intermodularhotel.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abelgarciavicario.intermodularhotel.inicio.ui.components.Inicio

@Composable

fun NavigationHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.Inicio.route
    ) {
        composable(Destinations.Inicio.route){
            Inicio(navController)
        }
    }
}