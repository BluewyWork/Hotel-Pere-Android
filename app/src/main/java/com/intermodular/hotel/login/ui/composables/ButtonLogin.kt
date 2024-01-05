package com.intermodular.hotel.login.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ButtonLogin(text: String, color: Color, navController: NavController) {
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
