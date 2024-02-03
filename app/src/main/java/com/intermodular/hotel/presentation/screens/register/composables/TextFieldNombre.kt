package com.intermodular.hotel.presentation.screens.register.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldNombre(nombre: String, onTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(top = 25.dp)
            .padding(start = 10.dp),
        value = nombre,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Nombre") },
        leadingIcon = { Icon(Icons.Default.AccountCircle, null) }
    )
}
