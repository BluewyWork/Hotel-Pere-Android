package com.intermodular.hotel.registro.ui.composables

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
fun TextFieldPassword(password: String, onTextChange: (String) -> Unit) {
    TextField(modifier = Modifier
        .width(400.dp)
        .padding(top = 25.dp)
        .padding(start = 10.dp),
        value = password,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { Text(text = "Password") },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}
