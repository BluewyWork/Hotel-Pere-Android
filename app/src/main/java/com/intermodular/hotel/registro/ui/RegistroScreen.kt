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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.intermodular.hotel.R
import com.intermodular.hotel.navigations.Destinations
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaClaro
import com.intermodular.hotel.ui.theme.turquesaOscuroFuerte
import com.intermodular.hotel.ui.theme.turquesaPrincipal


@Composable
fun Registro(
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
            IconBack {
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
            TextFieldMailR(email) {
                registroViewModel.onRegistroChange(nombre, it, password, passwordR)
            }

            TextFieldPasswordR(password) {
                registroViewModel.onRegistroChange(nombre, email, it, passwordR)
            }
            TextFieldPasswordRe(passwordR) {
                registroViewModel.onRegistroChange(nombre, email, password, it)
            }
            ButtonReg("Registrarse", turquesaOscuroFuerte, isLogEnable, registroViewModel,
                navController, onClick = {})

            Text("Registrate con", 20, turquesaOscuroFuerte)
            Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                ButtonWhith(image = R.drawable.logo_facebook)
                ButtonWhith(image = R.drawable.logo_google)
            }
            Row(modifier = Modifier.clickable { }) {
                Text("¿Ya tienes cuenta?", 18, turquesaOscuroFuerte)
                Text("Inicia sesión aqui", 18, turquesaOscuroFuerte)
            }
        }

    }

}

@Composable
fun IconBack(onClick: () -> Unit) {
    Icon(
        Icons.Default.KeyboardArrowLeft, "Atras",
        tint = turquesaClaro,
        modifier = Modifier.clickable { onClick() }
    )
}

@Composable
fun ButtonWhith(image: Int) {
    Image(
        modifier = Modifier
            .size(35.dp)
            .clickable { },
        painter = painterResource(id = image),
        contentDescription = "null",
    )

}

@Composable
fun Text(text: String, fontSize: Int, color: Color) {
    androidx.compose.material3.Text(text = text, fontSize = fontSize.sp, color = color)
}

@Composable
fun ButtonReg(
    text: String, color: Color, logEnable: Boolean, registroViewModel: RegistroViewModel,
    navController: NavController,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        onClick = {/*registroViewModel.onRegistroSelected(navController)*/ },
        enabled = logEnable,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        androidx.compose.material3.Text(text = text)
    }
}

@Composable
fun TextFieldPasswordR(password: String, onTextChange: (String) -> Unit) {
    TextField(modifier = Modifier
        .width(400.dp)
        .padding(top = 25.dp)
        .padding(start = 10.dp),
        value = password,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { androidx.compose.material3.Text(text = "Password") },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}

@Composable
fun TextFieldPasswordRe(passwordR: String, onTextChange: (String) -> Unit) {
    TextField(modifier = Modifier
        .width(400.dp)
        .padding(top = 25.dp)
        .padding(start = 10.dp),
        value = passwordR,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { androidx.compose.material3.Text(text = "Repetir Password") },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}


@Composable
fun TextFieldNombre(nombre: String, onTextChange: (String) -> Unit) {

    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(top = 25.dp)
            .padding(start = 10.dp),
        value = nombre,
        onValueChange = { onTextChange(it) },
        placeholder = { androidx.compose.material3.Text(text = "Nombre") },
        leadingIcon = { Icon(Icons.Default.AccountCircle, null) }
    )
}

@Composable
fun TextFieldMailR(email: String, onTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(top = 25.dp)
            .padding(start = 10.dp),
        value = email,
        onValueChange = { onTextChange(it) },
        placeholder = { androidx.compose.material3.Text(text = "Email") },
        leadingIcon = { Icon(Icons.Default.Email, null) }
    )
}

@Composable
fun MostrarError(viewModel: RegistroViewModel) {
    val errorMessage = viewModel.errorMessage.observeAsState()

    errorMessage.value?.let { message ->
        AlertDialog(
            onDismissRequest = { viewModel.clearErrorMessage() },
            title = { androidx.compose.material3.Text("Error") },
            text = { message },
            confirmButton = {
                Button(onClick = { viewModel.clearErrorMessage() }) {
                    androidx.compose.material3.Text("OK")
                }
            }
        )
    }
}


