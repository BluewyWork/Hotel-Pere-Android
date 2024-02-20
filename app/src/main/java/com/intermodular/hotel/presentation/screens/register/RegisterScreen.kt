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
import com.intermodular.hotel.presentation.screens.profile.composables.NameTextField
import com.intermodular.hotel.presentation.screens.profile.composables.SurnameTextField
import com.intermodular.hotel.presentation.screens.register.composables.ConfirmPasswordTextField
import com.intermodular.hotel.presentation.screens.register.composables.EmailTextField
import com.intermodular.hotel.presentation.screens.register.composables.LoginText
import com.intermodular.hotel.presentation.screens.register.composables.LogoButton
import com.intermodular.hotel.presentation.screens.register.composables.MostrarError
import com.intermodular.hotel.presentation.screens.register.composables.PasswordTextField
import com.intermodular.hotel.presentation.screens.register.composables.RegisterButton
import com.intermodular.hotel.presentation.screens.register.composables.Text
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
                navController.navigate(Destinations.Login.route)
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
    val password: String by registerViewModel.password.observeAsState(initial = "")
    val confirmPassword: String by registerViewModel.confirmPassword.observeAsState(initial = "")
    val name: String by registerViewModel.name.observeAsState(initial = "")
    val surname: String by registerViewModel.surname.observeAsState(initial = "")
    val email: String by registerViewModel.email.observeAsState(initial = "")

    val isLogEnable: Boolean by registerViewModel.isLogEnabled.observeAsState(initial = false)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("¡Hola! Registrate para comenzar", 22, turquesaPrincipal)
            MostrarError(viewModel = registerViewModel)
            NameTextField(name) {
                registerViewModel.onNameChange(it)
            }
            SurnameTextField(apellido = surname) {
                registerViewModel.onSurnameChange(it)
            }
            EmailTextField(email) {
                registerViewModel.onEmailChange(it)
            }
            PasswordTextField(password) {
                registerViewModel.onPasswordChange(it)
            }
            ConfirmPasswordTextField(confirmPassword) {
                registerViewModel.onConfirmPasswordChange(it)
            }
            Row(modifier = Modifier.clickable { navController.navigate("login")  }) {
                Text("¿Ya tienes cuenta?", 18, turquesaOscuroFuerte)
                Text("Inicia sesión aqui", 18, turquesaOscuroFuerte)
            }
            RegisterButton(
                onClick = { registerViewModel.onRegisterPress(navController) }
            )
            
         
        }
    }
}


















