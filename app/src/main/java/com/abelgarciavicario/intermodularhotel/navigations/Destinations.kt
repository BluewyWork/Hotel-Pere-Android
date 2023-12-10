package com.abelgarciavicario.intermodularhotel.navigations

sealed class Destinations(
    val route: String
) {
    object Inicio: Destinations("inicio")
    object Login: Destinations("log")
    object Registro: Destinations("registro")
    object RecuperarPassword: Destinations("recuperar")
    object CodigoVerificacion: Destinations("codigo")
    object CheckCambio: Destinations("check")

}