package com.abelgarciavicario.intermodularhotel.inicio.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abelgarciavicario.intermodularhotel.R
import com.abelgarciavicario.intermodularhotel.ui.theme.turquesaClaro
import com.abelgarciavicario.intermodularhotel.ui.theme.turquesaOscuroFuerte
import com.abelgarciavicario.intermodularhotel.ui.theme.turquesaPrincipal

@Composable
fun Inicio(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Column{
            Image(
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription = null,
                modifier = Modifier.size(450.dp),
            )

            Box(modifier= Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(color= turquesaClaro)
                .offset(y = (-90).dp)
                ){
                Body(navController)
            }

        }

    }
}

@Composable
fun Body(navController: NavController) {
    Box(
        modifier = Modifier
            .padding(30.dp)
            .background(color = Color.White,
                shape = RoundedCornerShape(16.dp))
            .border(
                width = 2.dp, // Ancho del borde
                color = turquesaOscuroFuerte, // Color del borde
                shape = RoundedCornerShape(16.dp),
            ),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top=20.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutButton( text = "Ingresa con Google", image = R.drawable.logo_google)
            OutButton(text = "Ingresa con Facebook", image = R.drawable.logo_facebook)
            ButtonReg(text = "Iniciar sesion", color = turquesaPrincipal){
               // navController.navigate(Destinations.DeliveryIniciarSesion.route)
            }
            ButtonReg(text = "Registrate gratis", color = turquesaPrincipal){
              //  navController.navigate(Destinations.Registro.route)
            }
            Text(text = "Olvidé la contraseña",
                color= turquesaOscuroFuerte,
                fontSize = 16.sp)

        }
    }
}


@Composable
fun OutButton(text:String, image:Int){
    OutlinedButton(
        modifier = Modifier.fillMaxWidth()
            .padding(start= 30.dp, end=30.dp),
        onClick = { /*TODO*/ }) {
        Row {
            Image(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(20.dp),
                painter = painterResource(id = image),
                contentDescription = "logo aplicación",
            )
            Text(text)
        }
    }
}
@Composable
fun ButtonReg(text: String, color: Color, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp, start = 30.dp),
        onClick =  onClick,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(text = text)
    }
}