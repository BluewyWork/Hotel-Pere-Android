package com.intermodular.hotel.core.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intermodular.hotel.carrito.ui.CarritoScreen
import com.intermodular.hotel.checkCambio.ui.CheckCambio
import com.intermodular.hotel.codigoVerificacion.ui.CodigoVerificacion
import com.intermodular.hotel.home.ui.HomeScreen
import com.intermodular.hotel.login.ui.LoginScreen
import com.intermodular.hotel.perfil.ui.Perfil
import com.intermodular.hotel.recuperarPassword.ui.RecuperarPassword
import com.intermodular.hotel.registro.ui.Registro
import com.intermodular.hotel.registro.ui.RegistroViewModel

@Composable

fun NavigationHost(
    registroViewModel: RegistroViewModel,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.Login.route
    ) {
        composable(Destinations.Login.route) {
            LoginScreen(navController)
        }
        composable(Destinations.Registro.route) {
            Registro(navController, registroViewModel)
        }
        composable(Destinations.RecuperarPassword.route) {
            RecuperarPassword(navController)
        }
        composable(Destinations.CodigoVerificacion.route) {
            CodigoVerificacion(navController)
        }
        composable(Destinations.CheckCambio.route) {
            CheckCambio(navController)
        }
        composable(Destinations.Perfil.route) {
            Perfil(navController)
        }
        composable(Destinations.Carrito.route) {
            CarritoScreen(navController)
        }
        composable(Destinations.Home.route) {
            HomeScreen(navController)
        }
    }
}