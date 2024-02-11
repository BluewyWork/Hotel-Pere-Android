package com.intermodular.hotel.presentation.screens.register.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ConfirmPasswordTextField(passwordR: String, onTextChange: (String) -> Unit) {
    TextField(modifier = Modifier
        .width(400.dp)
        .padding(top = 25.dp)
        .padding(start = 10.dp),
        value = passwordR,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { Text(text = "Repetir Password") },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}