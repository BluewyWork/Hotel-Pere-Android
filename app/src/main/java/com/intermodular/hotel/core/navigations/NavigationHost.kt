package com.intermodular.hotel.core.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intermodular.hotel.carrito.ui.CarritoScreen
import com.intermodular.hotel.carrito.ui.CarritoViewModel
import com.intermodular.hotel.codigoVerificacion.ui.CodigoVerificacionScreen
import com.intermodular.hotel.comprobarCambio.ui.ComprobarCambioScreen
import com.intermodular.hotel.home.ui.HomeScreen
import com.intermodular.hotel.login.ui.LoginScreen
import com.intermodular.hotel.perfil.ui.PerfilScreen
import com.intermodular.hotel.recuperarContrasenia.ui.RecuperarPasswordScreen
import com.intermodular.hotel.registro.ui.RegistroScreen
import com.intermodular.hotel.registro.ui.RegistroViewModel

@Composable

fun NavigationHost(
    registroViewModel: RegistroViewModel,
    carritoViewModel: CarritoViewModel,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route
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
            CodigoVerificacionScreen(navController)
        }
        composable(Destinations.CheckCambio.route) {
            ComprobarCambioScreen(navController)
        }
        composable(Destinations.Perfil.route) {
            PerfilScreen(navController)
        }
        composable(Destinations.Carrito.route) {
            CarritoScreen(navController, carritoViewModel)
        }
        composable(Destinations.Home.route) {
            HomeScreen(navController)
        }
    }
}