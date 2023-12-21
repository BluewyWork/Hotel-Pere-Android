package com.abelgarciavicario.intermodularhotel.inicio.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abelgarciavicario.intermodularhotel.R
import com.abelgarciavicario.intermodularhotel.ui.theme.gradient1
import com.abelgarciavicario.intermodularhotel.ui.theme.gradient2
import com.abelgarciavicario.intermodularhotel.ui.theme.gradient3
import com.abelgarciavicario.intermodularhotel.ui.theme.gradient4
import com.abelgarciavicario.intermodularhotel.ui.theme.gradient5
import com.abelgarciavicario.intermodularhotel.ui.theme.turquesaOscuroFuerte
import com.abelgarciavicario.intermodularhotel.ui.theme.turquesaPrincipal

@Composable
fun Inicio(
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
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonReg(text = "Iniciar sesion", color = turquesaPrincipal) {
                // navController.navigate(Destinations.DeliveryIniciarSesion.route)
            }
            ButtonReg(text = "Registrate gratis", color = turquesaPrincipal) {
                //  navController.navigate(Destinations.Registro.route)
            }
            ButtonOut(
                text = "Ingresa con Google", color = Color.White,
                image = R.drawable.logo_google
            ) {

            }
            ButtonOut(
                text = "Ingresa con Facebook", color = Color.White,
                image = R.drawable.logo_facebook
            ) {

            }
            Text(
                text = "Olvidé la contraseña",
                color = turquesaPrincipal,
                fontSize = 16.sp
            )

        }
    }
}

@Composable
fun ButtonReg(text: String, color: Color, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp, start = 30.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(text = text)
    }
}

@Composable
fun ButtonOut(text: String, color: Color, image: Int, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp, start = 30.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Row {
            Image(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(20.dp)
                    .background(color = Color.Transparent),
                painter = painterResource(id = image),
                contentDescription = "logo aplicación",
            )
            Text(text, color = turquesaPrincipal)
        }
    }
}