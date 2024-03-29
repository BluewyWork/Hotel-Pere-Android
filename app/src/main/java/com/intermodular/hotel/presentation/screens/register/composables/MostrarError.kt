package com.intermodular.hotel.presentation.screens.register.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.intermodular.hotel.presentation.screens.register.RegisterViewModel

@Composable
fun MostrarError(viewModel: RegisterViewModel) {
    val errorMessage = viewModel.errorMessage.observeAsState()

    errorMessage.value?.let { message ->
        AlertDialog(
            onDismissRequest = { viewModel.clearErrorMessage() },
            title = { Text("Error") },
            text = { message },
            confirmButton = {
                Button(onClick = { viewModel.clearErrorMessage() }) {
                    Text("OK")
                }
            }
        )
    }
}
