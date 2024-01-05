package com.intermodular.hotel.registro.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.R
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.registro.ui.composables.ButtonLogo
import com.intermodular.hotel.registro.ui.composables.ButtonRegistro
import com.intermodular.hotel.registro.ui.composables.IconAtras
import com.intermodular.hotel.registro.ui.composables.MostrarError
import com.intermodular.hotel.registro.ui.composables.Text
import com.intermodular.hotel.registro.ui.composables.TextFieldMail
import com.intermodular.hotel.registro.ui.composables.TextFieldNombre
import com.intermodular.hotel.registro.ui.composables.TextFieldPassword
import com.intermodular.hotel.registro.ui.composables.TextFieldPasswordConfirmar
import com.intermodular.hotel.registro.ui.composables.TextLogin
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaOscuroFuerte
import com.intermodular.hotel.ui.theme.turquesaPrincipal


@Composable
fun RegistroScreen(
    navController: NavController,
    registroViewModel: RegistroViewModel
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        gradient1,
                        gradient2,
                        gradient3,
                        gradient4,
                        gradient5,
                    )
                )
            ),
        contentAlignment = Alignment.Center

    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            IconAtras {
                navController.navigate(Destinations.Registro.route)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_sin_fondo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(180.dp)
                        .offset(100.dp, -40.dp)
                )


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 0.dp, end = 10.dp, start = 10.dp)
                        .offset(0.dp, -35.dp)
                ) {
                    BodyR(navController, registroViewModel)
                }
            }


        }

    }
}

@Composable
fun BodyR(
    navController: NavController,
    registroViewModel: RegistroViewModel
) {
    val email: String by registroViewModel.email.observeAsState(initial = "")
    val password: String by registroViewModel.password.observeAsState(initial = "")
    val nombre: String by registroViewModel.nombre.observeAsState(initial = "")
    val passwordR: String by registroViewModel.passwordR.observeAsState(initial = "")
    val isLogEnable: Boolean by registroViewModel.isLogEnable.observeAsState(initial = false)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("¡Hola! Registrate para comenzar", 22, turquesaPrincipal)

            MostrarError(viewModel = registroViewModel)
            TextFieldNombre(nombre) {
                registroViewModel.onRegistroChange(it, email, password, passwordR)
            }
            TextFieldMail(email) {
                registroViewModel.onRegistroChange(nombre, it, password, passwordR)
            }

            TextFieldPassword(password) {
                registroViewModel.onRegistroChange(nombre, email, it, passwordR)
            }
            TextFieldPasswordConfirmar(passwordR) {
                registroViewModel.onRegistroChange(nombre, email, password, it)
            }
            TextLogin(navController = navController)
            ButtonRegistro("Registrarse", turquesaOscuroFuerte, isLogEnable, registroViewModel,
                navController, onClick = {})

            Text("Registrate con", 20, turquesaOscuroFuerte)
            Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                ButtonLogo(image = R.drawable.logo_facebook)
                ButtonLogo(image = R.drawable.logo_google)
            }
            Row(modifier = Modifier.clickable { }) {
                Text("¿Ya tienes cuenta?", 18, turquesaOscuroFuerte)
                Text("Inicia sesión aqui", 18, turquesaOscuroFuerte)
            }
        }

    }

}


















