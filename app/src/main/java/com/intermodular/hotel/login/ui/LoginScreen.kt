package com.intermodular.hotel.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.R
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaOscuroFuerte
import com.intermodular.hotel.ui.theme.turquesaPrincipal
import com.intermodular.hotel.login.ui.composables.*

@Composable
fun LoginScreen(
    navController: NavController
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
            Image(
                painter = painterResource(id = R.drawable.logo_sin_fondo),
                contentDescription = null,
                modifier = Modifier.size(400.dp),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(20.dp)
            ) {
                Body(navController)
            }

        }

    }
}

@Composable
fun Body(navController: NavController) {
    // val password: String by LogViewModel.password.observeAsState(initial="")
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
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextFieldMail(email = "Mail") {

            }

            TextFieldPassword(password = "Contraseña") {

            }
            
            TextRegister(navController = navController)

            ButtonLogin(text = "Iniciar sesión", color = turquesaPrincipal, navController = navController)

        }
    }
}
