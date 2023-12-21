package com.abelgarciavicario.intermodularhotel.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abelgarciavicario.intermodularhotel.carrito.ui.CarritoScreen
import com.abelgarciavicario.intermodularhotel.checkCambio.ui.CheckCambio
import com.abelgarciavicario.intermodularhotel.codigoVerificacion.ui.CodigoVerificacion
import com.abelgarciavicario.intermodularhotel.inicio.ui.Inicio
import com.abelgarciavicario.intermodularhotel.login.ui.Login
import com.abelgarciavicario.intermodularhotel.perfil.ui.Perfil
import com.abelgarciavicario.intermodularhotel.recuperarPassword.ui.RecuperarPassword
import com.abelgarciavicario.intermodularhotel.registro.ui.Registro
import com.abelgarciavicario.intermodularhotel.registro.ui.RegistroViewModel

@Composable

fun NavigationHost(
    registroViewModel: RegistroViewModel,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.Perfil.route
    ) {
        composable(Destinations.Inicio.route) {
            Inicio(navController)
        }
        composable(Destinations.Login.route) {
            Login(navController)
        }
        composable(Destinations.Registro.route) {
            Registro(navController, registroViewModel)
        }
        composable(Destinations.RecuperarPassword.route) {
            RecuperarPassword(navController)
        }
        composable(Destinations.CodigoVerificacion.route) {
            CodigoVerificacion(navController)
        }
        composable(Destinations.CheckCambio.route) {
            CheckCambio(navController)
        }
        composable(Destinations.Perfil.route) {
            Perfil(navController)
        }
        composable(Destinations.Perfil.route) {
            CarritoScreen(navController)
        }
    }
}