package com.intermodular.hotel.presentation.screens.register

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
import com.intermodular.hotel.presentation.composables.IconAtras
import com.intermodular.hotel.presentation.screens.register.composables.ButtonLogo
import com.intermodular.hotel.presentation.screens.register.composables.ButtonRegistro
import com.intermodular.hotel.presentation.screens.register.composables.MostrarError
import com.intermodular.hotel.presentation.screens.register.composables.Text
import com.intermodular.hotel.presentation.screens.register.composables.TextFieldMail
import com.intermodular.hotel.presentation.screens.register.composables.TextFieldNombre
import com.intermodular.hotel.presentation.screens.register.composables.TextFieldPassword
import com.intermodular.hotel.presentation.screens.register.composables.TextFieldPasswordConfirmar
import com.intermodular.hotel.presentation.screens.register.composables.TextLogin
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaOscuroFuerte
import com.intermodular.hotel.ui.theme.turquesaPrincipal

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel
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
                navController.navigate(Destinations.Register.route)
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
                    Register(navController, registerViewModel)
                }
            }
        }
    }
}

@Composable
fun Register(
    navController: NavController,
    registerViewModel: RegisterViewModel
) {
    val email: String by registerViewModel.email.observeAsState(initial = "")
    val password: String by registerViewModel.password.observeAsState(initial = "")
    val nombre: String by registerViewModel.nombre.observeAsState(initial = "")
    val passwordR: String by registerViewModel.passwordR.observeAsState(initial = "")
    val isLogEnable: Boolean by registerViewModel.isLogEnable.observeAsState(initial = false)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("¡Hola! Registrate para comenzar", 22, turquesaPrincipal)

            MostrarError(viewModel = registerViewModel)
            TextFieldNombre(nombre) {
                registerViewModel.onRegistroChange(it, email, password, passwordR)
            }
            TextFieldMail(email) {
                registerViewModel.onRegistroChange(nombre, it, password, passwordR)
            }

            TextFieldPassword(password) {
                registerViewModel.onRegistroChange(nombre, email, it, passwordR)
            }
            TextFieldPasswordConfirmar(passwordR) {
                registerViewModel.onRegistroChange(nombre, email, password, it)
            }
            TextLogin(navController = navController)
            ButtonRegistro("Registrarse", turquesaOscuroFuerte, isLogEnable, registerViewModel,
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


















