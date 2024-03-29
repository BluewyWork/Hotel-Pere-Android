package com.intermodular.hotel.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.R
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.presentation.composables.IconAtras
import com.intermodular.hotel.presentation.screens.login.composables.EmailTextField
import com.intermodular.hotel.presentation.screens.login.composables.LoginButton
import com.intermodular.hotel.presentation.screens.login.composables.PasswordTextField
import com.intermodular.hotel.presentation.screens.login.composables.RegisterTextField
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaOscuroFuerte

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
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
        Column {

            Box(modifier = Modifier.fillMaxWidth().padding(10.dp)){
                IconAtras {
                    navController.navigate(Destinations.Home.route)
                }
            }
            Image(
                painter = painterResource(id = R.drawable.logo_sin_fondo),
                contentDescription = null,
                modifier = Modifier.size(400.dp),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp).padding(bottom = 10.dp , end = 20.dp, start = 20.dp),
            ) {
                Login(navController, loginViewModel)
            }
        }
    }
}

@Composable
fun Login(navController: NavController, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    Box(
        modifier = Modifier
            .background(
                color = Color.White.copy(alpha = 0.8f),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 2.dp,
                color = turquesaOscuroFuerte,
                shape = RoundedCornerShape(16.dp),
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailTextField(email = email) {
                loginViewModel.onEmailChange(
                    it
                )
            }

            PasswordTextField(password = password) {
                loginViewModel.onPasswordChange(
                    it
                )
            }
            RegisterTextField(navController = navController)
            LoginButton(loginViewModel, navController)

        }
    }
}
