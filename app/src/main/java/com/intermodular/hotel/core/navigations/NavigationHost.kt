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
import com.intermodular.hotel.perfil.ui.PerfilScreen
import com.intermodular.hotel.recuperarContrasenia.ui.RecuperarPasswordScreen
import com.intermodular.hotel.registro.ui.RegistroScreen
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
            RegistroScreen(navController, registroViewModel)
        }
        composable(Destinations.RecuperarPassword.route) {
            RecuperarPasswordScreen(navController)
        }
        composable(Destinations.CodigoVerificacion.route) {
            CodigoVerificacion(navController)
        }
        composable(Destinations.CheckCambio.route) {
            CheckCambio(navController)
        }
        composable(Destinations.Perfil.route) {
            PerfilScreen(navController)
        }
        composable(Destinations.Carrito.route) {
            CarritoScreen(navController)
        }
        composable(Destinations.Home.route) {
            HomeScreen(navController)
        }
    }
}