package com.intermodular.hotel.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

            ButtonReg(text = "Iniciar sesión", color = turquesaPrincipal, navController = navController)

        }
    }
}

@Composable
fun ButtonReg(text: String, color: Color, navController: NavController) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, end = 30.dp, start = 40.dp),
        onClick = { navController.navigate("home") },
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(text = text)
    }
}

@Composable
fun TextFieldPassword(password: String, onTextChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(start = 15.dp, end = 15.dp),
        value = password,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Toggle password visibility"
                )
            }
        },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}

@Composable
fun TextFieldMail(email: String, onTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(start = 15.dp, end = 15.dp),
        value = email,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Email") },
        leadingIcon = { Icon(Icons.Default.Email, null) }
    )
}

@Composable
fun TextRegister(navController: NavController) {
    Text(
        modifier = Modifier
            .clickable { navController.navigate("registro") },
        text = "Haz click aqui para registrarte!"
    )
}