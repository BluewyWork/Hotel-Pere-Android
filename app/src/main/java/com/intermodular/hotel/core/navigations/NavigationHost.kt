package com.intermodular.hotel.core.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intermodular.hotel.cart.ui.CarritoScreen
import com.intermodular.hotel.cart.ui.CartViewModel
import com.intermodular.hotel.codigoVerificacion.ui.CodigoVerificacionScreen
import com.intermodular.hotel.comprobarCambio.ui.ComprobarCambioScreen
import com.intermodular.hotel.habitacionDetalles.DetailsScreen
import com.intermodular.hotel.home.ui.HomeScreen
import com.intermodular.hotel.home.ui.HomeViewModel
import com.intermodular.hotel.login.ui.LoginScreen
import com.intermodular.hotel.login.ui.LoginViewModel
import com.intermodular.hotel.profile.ui.ProfileScreen
import com.intermodular.hotel.profile.ui.ProfileViewModel
import com.intermodular.hotel.recuperarContrasenia.ui.RecuperarPasswordScreen
import com.intermodular.hotel.registro.ui.RegistroScreen
import com.intermodular.hotel.registro.ui.RegistroViewModel
import com.intermodular.hotel.reservationsOverview.ui.ReservationsOverviewScreen
import com.intermodular.hotel.reservationsOverview.ui.ReservationsOverviewViewModel

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