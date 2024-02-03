package com.intermodular.hotel.presentation.screens.recoverPassword


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.intermodular.hotel.presentation.screens.recoverPassword.composables.TexFieldMail
import com.intermodular.hotel.presentation.screens.recoverPassword.composables.TextIngresar
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaPrincipal

@Composable
fun RecoverPasswordScreen(navController: NavController) {
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
    ) {
        Column(
            Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_sin_fondo),
                contentDescription = null,
                Modifier.size(350.dp)
            )
            Body(navController)
        }

    }

}

@Composable
fun Body(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
            .background(
                color = Color.White.copy(alpha = 0.7f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 15.dp, start = 15.dp, top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿Has olvidado la contraseña?",
                fontSize = 20.sp
            )

            Text(
                text = "Ingrese correo",
                fontSize = 20.sp
            )

            TexFieldMail("Mail") {

            }

            Button(modifier = Modifier
                .width(250.dp),
                colors = ButtonDefaults.buttonColors(turquesaPrincipal),
                onClick = {
                }) {
                Text(text = "Enviar código")
            }
            Text(
                text = "    ¿Recuerdas la contraseña?",
                fontSize = 20.sp
            )

            TextIngresar(
                text = "Ingresar",
                color = turquesaPrincipal,
                fontSize = 18.sp,
            ) {

            }

        }
    }
}
