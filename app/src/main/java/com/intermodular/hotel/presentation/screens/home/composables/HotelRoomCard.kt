package com.intermodular.hotel.presentation.screens.home.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun HotelRoomCard(
    image: String,
    roomNumber: Int,
    numberOfBeds: Int,
    pricePerNight: Double,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    ),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Room Number: $roomNumber")
                Text(
                    text = "$numberOfBeds Beds",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = "$pricePerNight per night",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}
