package com.intermodular.hotel.login.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldMail(email: String, onTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(start = 15.dp, end = 15.dp),
        value = email,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Email") },
        leadingIcon = { Icon(Icons.Default.Email, null) }
    )
}