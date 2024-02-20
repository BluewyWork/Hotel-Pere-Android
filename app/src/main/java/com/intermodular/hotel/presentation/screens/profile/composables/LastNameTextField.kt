package com.intermodular.hotel.presentation.screens.profile.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SurnameTextField(apellido: String, onTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp),
        value = apellido,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Surname") },
        leadingIcon = { Icon(Icons.Default.Face, null) }
    )
}