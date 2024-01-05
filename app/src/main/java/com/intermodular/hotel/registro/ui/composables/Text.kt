package com.intermodular.hotel.registro.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Text(text: String, fontSize: Int, color: Color) {
    androidx.compose.material3.Text(text = text, fontSize = fontSize.sp, color = color)
}