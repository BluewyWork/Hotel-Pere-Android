package com.intermodular.hotel.presentation.screens.hotelRoomDetails.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithDialog(
    value: LocalDate?,
    dateFormatter: (LocalDate) -> String,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    onChange: (LocalDate?) -> Unit,
    modifier: Modifier
) {
    var openDialog by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = value?.atStartOfDay()?.toEpochSecond(ZoneOffset.UTC)
            ?.times(1000)
    )

    Box(modifier) {
        TextField(
            label = label,
            modifier = Modifier.fillMaxWidth(),
            value = value?.let(dateFormatter).orEmpty(),
            onValueChange = {},
            readOnly = true,
            enabled = enabled,
            trailingIcon = {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = ""
                )
            })

        Box(
            Modifier
                .clickable(enabled = enabled) { openDialog = true }
                .matchParentSize()) {
        }
    }

    if (openDialog) {
        val confirmEnabled by remember { derivedStateOf { datePickerState.selectedDateMillis != null } }
        DatePickerDialog(
            onDismissRequest = {
                openDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                        onChange(datePickerState.selectedDateMillis?.let {
                            Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
                        })
                    },
                    enabled = enabled && confirmEnabled
                ) {
                    Text(stringResource(id = android.R.string.ok))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text(stringResource(id = android.R.string.cancel))
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
            )
        }
    }
}