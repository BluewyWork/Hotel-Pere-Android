package com.intermodular.hotel.presentation.screens.cart.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.intermodular.hotel.domain.model.Room

@Composable
fun HotelRoomCard(hotelRooms: List<Room>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            for (hotelRoom in hotelRooms) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Text1(text = hotelRoom.roomId)
                    CustomText(text = "XXX EUROS")
                }
                Divider(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(text = "SUBTOTAL:")
                CustomText(text = "XXX Euros")
            }
        }
    }
}
