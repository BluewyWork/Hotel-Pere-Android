package com.intermodular.hotel.login.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.intermodular.hotel.login.ui.LoginViewModel

@Composable
fun ButtonLogin(loginViewModel: LoginViewModel, navController: NavController) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, end = 30.dp, start = 40.dp),
        onClick = { loginViewModel.onLoginPress(navController) },
    ) {
        Text("Iniciar Session")
    }
}
