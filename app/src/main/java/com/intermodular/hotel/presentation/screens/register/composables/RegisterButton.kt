package com.intermodular.hotel.presentation.screens.register.composables

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
import com.intermodular.hotel.presentation.screens.register.RegisterViewModel

@Composable
fun RegisterButton(
    text: String, color: Color, logEnable: Boolean, registerViewModel: RegisterViewModel,
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
        Text(text = text)
    }
}