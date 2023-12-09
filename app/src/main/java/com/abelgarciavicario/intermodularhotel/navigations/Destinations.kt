package com.abelgarciavicario.intermodularhotel.navigations

sealed class Destinations(
    val route: String
) {
    object Inicio: Destinations("inicio")
    object Log: Destinations("log")
    object Registro: Destinations("registro")
    object RecuperarPassword: Destinations("recuperar")

}