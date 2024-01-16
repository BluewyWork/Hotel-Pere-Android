package com.intermodular.hotel.habitacionDetalles

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.intermodular.hotel.R
import com.intermodular.hotel.composables.BottomBar
import com.intermodular.hotel.ui.theme.turquesaPrincipal


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomBar(navController) }) {
        Details()
    }
}

@Composable
fun Details(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
      item {
          Image(
              painter = painterResource(id = R.drawable.logo_app),
              contentDescription = "Sample",
              modifier = Modifier
                  .fillMaxWidth()
                  .height(280.dp)
                  .clip(shape = RoundedCornerShape(10.dp))
          );

          Spacer(modifier =Modifier.height(20.dp));
          Text(text = "Habitación Standard", Modifier.padding(start = 16.dp) ,  fontSize = 30.sp , fontWeight = FontWeight.Bold);
          Spacer(modifier =Modifier.height(20.dp));

          Text(text = "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                  "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. "
              , modifier = Modifier.padding(start = 16.dp), fontSize = 18.sp)

          Spacer(modifier =Modifier.height(20.dp));


          Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
              .fillMaxSize()
              .padding(end = 16.dp) ) {
              Text(text = "Camas",Modifier.padding(start = 16.dp) , fontSize = 25.sp , fontWeight = FontWeight.Bold);

              Text(text = "2",Modifier.padding(start = 16.dp) , fontSize = 25.sp);
          }


          Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
              .fillMaxSize()
              .padding(end = 16.dp) ) {
              Text(text = "Wifi",Modifier.padding(start = 16.dp) , fontSize = 25.sp , fontWeight = FontWeight.Bold);
              Text(text = "Si",Modifier.padding(start = 16.dp) , fontSize = 25.sp);
          }

          Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
              .fillMaxSize()
              .padding(end = 16.dp) ) {
              Text(text = "Servicio",Modifier.padding(start = 16.dp) , fontSize = 25.sp , fontWeight = FontWeight.Bold);

              Text(text = "Si",Modifier.padding(start = 16.dp) , fontSize = 25.sp);
          }

          Spacer(modifier =Modifier.height(30.dp));

          Text(text = "200€/noche",Modifier.padding(start = 16.dp) , fontSize = 25.sp , fontWeight = FontWeight.Bold);

          Button(modifier = Modifier
              .fillMaxWidth()
              .padding(start = 16.dp,end = 16.dp),
              colors = ButtonDefaults.buttonColors(turquesaPrincipal),
              onClick = {
              }) {
              Text(text = "Reservar")
          }

          }
      }


}

