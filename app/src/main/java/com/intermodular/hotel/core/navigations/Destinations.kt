package com.intermodular.hotel.core.navigations

sealed class Destinations(
    val route: String
) {
    object Login : Destinations("login")
    object Register : Destinations("register")
    object RecoverPassword : Destinations("recoverPassword")
    object VerificationCode : Destinations("verificationCode")
    object CheckChange : Destinations("CheckChange")
    object Profile : Destinations("profile")
    object Cart : Destinations("cart")

    object Home : Destinations("home")

    object Details : Destinations("details")
    object ReservationsOverview : Destinations("reservationsOverview")
}