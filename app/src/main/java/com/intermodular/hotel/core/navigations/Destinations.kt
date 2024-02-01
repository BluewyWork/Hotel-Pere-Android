package com.intermodular.hotel.core.navigations

sealed class Destinations(
    val route: String
) {
    object Login : Destinations("login")
    object Registro : Destinations("registro")
    object RecuperarPassword : Destinations("recuperar")
    object CodigoVerificacion : Destinations("codigo")
    object CheckCambio : Destinations("check")
    object Profile : Destinations("profile")
    object Carrito : Destinations("carrito")

    object Home : Destinations("home")

    object Details : Destinations("details")
}