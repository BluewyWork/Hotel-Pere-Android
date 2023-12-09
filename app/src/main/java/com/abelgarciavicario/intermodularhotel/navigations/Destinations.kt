package com.abelgarciavicario.intermodularhotel.navigations

sealed class Destinations(
    val route: String
) {
    object Inicio: Destinations("inicio")
    object Login: Destinations("log")

}