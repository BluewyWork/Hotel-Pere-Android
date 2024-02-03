package com.intermodular.hotel.presentation.screens.verificationCode

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.intermodular.hotel.R
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.presentation.composables.IconAtras
import com.intermodular.hotel.presentation.screens.verificationCode.composables.NumberTextField
import com.intermodular.hotel.presentation.screens.verificationCode.composables.ResendText
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaOscuroFuerte
import com.intermodular.hotel.ui.theme.turquesaPrincipal

@Composable
fun VerificationCodeScreen(navController: NavController) {
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
                    Modifier.size(350.dp)
                )

                VerificationCode()
            }
        }
    }
}

@Composable
fun VerificationCode() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(
                color = Color.White.copy(alpha = 0.7f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 15.dp, start = 15.dp, top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Ingrese el código de verificación que acabamos de enviar a su correo",
                fontSize = 20.sp,
                color = turquesaOscuroFuerte
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(4) {
                    NumberTextField {

                    }
                }
            }
            Button(modifier = Modifier
                .width(250.dp),
                colors = ButtonDefaults.buttonColors(turquesaPrincipal),
                onClick = {
                }) {
                Text(text = "Verificar")
            }
            Text(
                text = "    ¿No recibiste el código?",
                fontSize = 20.sp
            )

            ResendText(
                text = "Renviar",
                color = turquesaOscuroFuerte,
                fontSize = 20.sp
            ) {
            }
        }
    }
}
