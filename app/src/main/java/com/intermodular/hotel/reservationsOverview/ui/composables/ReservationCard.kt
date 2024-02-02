package com.intermodular.hotel.reservationsOverview.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.Date

@Composable
fun ReservationCard(
    customerName: String,
    customerEmail: String,
    roomNumber: Int,
    pricePerNight: Double,
    checkIn: Date,
    checkOut: Date
) {
    Card(
        Modifier
            .fillMaxWidth()
    ) {
        Column() {
            Text(text = customerName)
            Text(text = customerEmail)
            Text(text = "$roomNumber")
            Text(text = "$pricePerNight")
            Text(text = "$checkIn")
            Text(text = "$checkOut")
        }
    }
}