package com.abelgarciavicario.intermodularhotel.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abelgarciavicario.intermodularhotel.inicio.ui.components.Inicio
import com.abelgarciavicario.intermodularhotel.login.ui.components.Log

@Composable

fun NavigationHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
       // startDestination = Destinations.Inicio.route
        startDestination = Destinations.Login.route
    ) {
        composable(Destinations.Inicio.route){
            Inicio(navController)
        }
        composable(Destinations.Login.route){
            Log(navController)
        }
    }
}