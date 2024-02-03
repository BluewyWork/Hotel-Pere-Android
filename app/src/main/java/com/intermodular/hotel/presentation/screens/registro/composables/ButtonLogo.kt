package com.intermodular.hotel.presentation.screens.registro.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ButtonLogo(image: Int) {
    Image(
        modifier = Modifier
            .size(35.dp)
            .clickable { },
        painter = painterResource(id = image),
        contentDescription = "null",
    )

}