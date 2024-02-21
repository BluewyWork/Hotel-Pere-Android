package com.intermodular.hotel.presentation.screens.profile.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmailTextField(email: String, enabled : Boolean = true, onTextChange: (String) -> Unit ) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp),
        value = email,
        enabled = enabled,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Email") },
        leadingIcon = { Icon(Icons.Default.Email, null) }
    )
}
