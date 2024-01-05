package com.intermodular.hotel.codigoVerificacion.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.intermodular.hotel.ui.theme.turquesaClaro

@Composable
fun IconAtras(onClick: () -> Unit) {
    Icon(
        Icons.Default.KeyboardArrowLeft, "Atras",
        tint = turquesaClaro,
        modifier = Modifier.clickable { onClick() }
    )
}
