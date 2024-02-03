package com.intermodular.hotel.presentation.screens.register.composables

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TextLogin(navController: NavController) {
    androidx.compose.material3.Text(
        modifier = Modifier
            .clickable { navController.navigate("login") },
        text = "Ya tienes cuenta? Haz click aqui para logearte!"
    )
}
