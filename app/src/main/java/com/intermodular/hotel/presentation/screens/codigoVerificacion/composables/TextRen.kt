package com.intermodular.hotel.presentation.screens.codigoVerificacion.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextRen(text: String, color: Color, fontSize: TextUnit, content: () -> Unit) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize
    )
    content()
}
