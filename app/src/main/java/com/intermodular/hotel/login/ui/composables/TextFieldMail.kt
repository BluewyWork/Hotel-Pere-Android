package com.intermodular.hotel.login.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldMail(email: String, onTextFieldChange: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextFieldChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        placeholder = { Text(text = "Email") },
        leadingIcon = { Icon(Icons.Default.Email, null) }

    )
}
