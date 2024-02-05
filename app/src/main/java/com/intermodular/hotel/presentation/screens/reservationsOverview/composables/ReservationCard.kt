package com.intermodular.hotel.presentation.screens.reservationsOverview.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

@Composable
fun ReservationCard(
    customerName: String,
    customerEmail: String,
    roomNumber: Int,
    pricePerNight: Double,
    checkIn: LocalDateTime,
    checkOut: LocalDateTime
) {
    Card(
        Modifier
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .padding(8.dp)
        ) {
            CustomRow(label = "Name:", value = customerName)
            Divider()
            CustomRow(label = "Email:", value = customerEmail)
            Divider()
            CustomRow(label = "Room Number: ", value = "$roomNumber")
            Divider()
            CustomRow(label = "Price Per Night: ", value = "$pricePerNight")
            Divider()
            CustomRow(label = "Check In: ", value = "$checkIn")
            Divider()
            CustomRow(label = "Check Out: ", value = "$checkOut")
        }
    }
}

@Composable
fun CustomRow(label: String, value: String) {
    Row() {
        Text(label, textAlign = TextAlign.Start)
        Text(value, textAlign = TextAlign.End)
    }
}