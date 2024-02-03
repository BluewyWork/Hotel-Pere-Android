package com.intermodular.hotel.core.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intermodular.hotel.presentation.screens.cart.CartScreen
import com.intermodular.hotel.presentation.screens.cart.CartViewModel
import com.intermodular.hotel.presentation.screens.checkChange.CheckChangeScreen
import com.intermodular.hotel.presentation.screens.home.HomeScreen
import com.intermodular.hotel.presentation.screens.home.HomeViewModel
import com.intermodular.hotel.presentation.screens.hotelRoomDetails.HotelRoomDetails
import com.intermodular.hotel.presentation.screens.login.LoginScreen
import com.intermodular.hotel.presentation.screens.login.LoginViewModel
import com.intermodular.hotel.presentation.screens.profile.ProfileScreen
import com.intermodular.hotel.presentation.screens.profile.ProfileViewModel
import com.intermodular.hotel.presentation.screens.recoverPassword.RecoverPasswordScreen
import com.intermodular.hotel.presentation.screens.register.RegisterScreen
import com.intermodular.hotel.presentation.screens.register.RegisterViewModel
import com.intermodular.hotel.presentation.screens.reservationsOverview.ReservationsOverviewScreen
import com.intermodular.hotel.presentation.screens.reservationsOverview.ReservationsOverviewViewModel
import com.intermodular.hotel.presentation.screens.verificationCode.VerificationCodeScreen

@Composable
fun NavigationHost(
    registerViewModel: RegisterViewModel,
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
        composable(Destinations.Register.route) {
            RegisterScreen(navController, registerViewModel)
        }
        composable(Destinations.RecoverPassword.route) {
            RecoverPasswordScreen(navController)
        }
        composable(Destinations.VerificationCode.route) {
            VerificationCodeScreen(navController)
        }
        composable(Destinations.CheckChange.route) {
            CheckChangeScreen(navController)
        }
        composable(Destinations.Profile.route) {
            ProfileScreen(navController, profileViewModel)
        }
        composable(Destinations.Cart.route) {
            CartScreen(navController, cartViewModel)
        }
        composable(Destinations.Home.route) {
            HomeScreen(navController, homeViewModel)
        }
        composable(Destinations.Details.route) {
            HotelRoomDetails(navController)
        }
        composable(Destinations.ReservationsOverview.route) {
            ReservationsOverviewScreen(reservationsOverviewViewModel, navController)
        }
    }
}