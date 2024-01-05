package com.intermodular.hotel.login.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TextRegister(navController: NavController) {
    Text(
        modifier = Modifier
            .clickable { navController.navigate("registro") },
        text = "Haz click aqui para registrarte!"
    )
}
