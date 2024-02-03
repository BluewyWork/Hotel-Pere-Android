package com.intermodular.hotel.core.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intermodular.hotel.presentation.screens.cart.CarritoScreen
import com.intermodular.hotel.presentation.screens.cart.CartViewModel
import com.intermodular.hotel.presentation.screens.codigoVerificacion.CodigoVerificacionScreen
import com.intermodular.hotel.presentation.screens.comprobarCambio.ComprobarCambioScreen
import com.intermodular.hotel.presentation.screens.habitacionDetalles.DetailsScreen
import com.intermodular.hotel.presentation.screens.home.HomeScreen
import com.intermodular.hotel.presentation.screens.home.HomeViewModel
import com.intermodular.hotel.presentation.screens.login.LoginScreen
import com.intermodular.hotel.presentation.screens.login.LoginViewModel
import com.intermodular.hotel.presentation.screens.profile.ProfileScreen
import com.intermodular.hotel.presentation.screens.profile.ProfileViewModel
import com.intermodular.hotel.presentation.screens.recuperarContrasenia.RecuperarPasswordScreen
import com.intermodular.hotel.presentation.screens.registro.RegistroScreen
import com.intermodular.hotel.presentation.screens.registro.RegistroViewModel
import com.intermodular.hotel.presentation.screens.reservationsOverview.ReservationsOverviewScreen
import com.intermodular.hotel.presentation.screens.reservationsOverview.ReservationsOverviewViewModel

@Composable

fun NavigationHost(
    registroViewModel: RegistroViewModel,
    cartViewModel: CartViewModel,
    homeViewModel: HomeViewModel,
    loginViewModel: LoginViewModel,
    profileViewModel: ProfileViewModel,
    reservationsOverviewViewModel: ReservationsOverviewViewModel
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.ReservationsOverview.route
    ) {
        composable(Destinations.Login.route) {
            LoginScreen(navController, loginViewModel)
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
        composable(Destinations.Profile.route) {
            ProfileScreen(navController, profileViewModel)
        }
        composable(Destinations.Cart.route) {
            CarritoScreen(navController, cartViewModel)
        }
        composable(Destinations.Home.route) {
            HomeScreen(navController, homeViewModel)
        }
        composable(Destinations.Details.route) {
            DetailsScreen(navController)
        }
        composable(Destinations.ReservationsOverview.route) {
            ReservationsOverviewScreen(reservationsOverviewViewModel, navController)
        }
    }
}