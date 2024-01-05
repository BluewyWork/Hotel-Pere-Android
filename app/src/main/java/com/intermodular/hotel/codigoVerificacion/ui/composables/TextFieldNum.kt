package com.intermodular.hotel.codigoVerificacion.ui.composables

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldNum(content: () -> Unit) {
    var num1 by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.width(65.dp),
        value = num1,
        placeholder = { Text(text = "   -", fontSize = 16.sp) },
        onValueChange = { num1 = it },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center
        )
    )
}
