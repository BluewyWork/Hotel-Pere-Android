package com.intermodular.hotel.presentation.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.intermodular.hotel.R
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.presentation.composables.IconAtras
import com.intermodular.hotel.presentation.screens.profile.composables.EmailTextField
import com.intermodular.hotel.presentation.screens.profile.composables.NameTextField
import com.intermodular.hotel.presentation.screens.profile.composables.SurnameTextField
import com.intermodular.hotel.ui.theme.gradient1
import com.intermodular.hotel.ui.theme.gradient2
import com.intermodular.hotel.ui.theme.gradient3
import com.intermodular.hotel.ui.theme.gradient4
import com.intermodular.hotel.ui.theme.gradient5
import com.intermodular.hotel.ui.theme.turquesaPrincipal

@Composable
fun ProfileScreen(navController: NavController, profileViewModel: ProfileViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        gradient1,
                        gradient2,
                        gradient3,
                        gradient4,
                        gradient5,
                    )
                )
            ),
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp, start = 20.dp)) {
            IconAtras {
                navController.navigate(Destinations.Home.route)
            }
        }
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .size(250.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            ) {
                Box {
                    Column {

                        Image(
                            painter = painterResource(id = R.drawable.perfil_muestra),
                            contentDescription = "Imagen de perfil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )
                    }
                }
            }
            Profile(profileViewModel, navController)
        }
    }
}

@Composable
fun Profile(profileViewModel: ProfileViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(
                color = Color.White.copy(alpha = 0.7f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 20.dp, start = 15.dp, top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tu información",
                fontSize = 20.sp
            )
            ConjuntoTextFieldPerfil(profileViewModel)
            Button(modifier = Modifier
                .width(250.dp),
                colors = ButtonDefaults.buttonColors(turquesaPrincipal),
                onClick = {
                    profileViewModel.onUpdatePress()
                }
            ) {
                Text(text = "Actualizar")
            }
            Button(modifier = Modifier
                .width(250.dp),
                colors = ButtonDefaults.buttonColors(turquesaPrincipal),
                onClick = {
                    profileViewModel.onDeleteAccountPress()
                }
            ) {
                Text(text = "Borrar Cuenta")
            }
        }
    }
}

@Composable
fun ConjuntoTextFieldPerfil(profileViewModel: ProfileViewModel) {
    val name: String by profileViewModel.name.observeAsState(initial = "")
    val surname: String by profileViewModel.surname.observeAsState(initial = "")
    val email: String by profileViewModel.email.observeAsState(initial = "")

    NameTextField(name) {
        profileViewModel.onUsernameChange(it)
    }
    SurnameTextField(surname) {
        profileViewModel.onLastNameChange(it)
    }
    EmailTextField(email) {
        profileViewModel.onEmailChange(it)
    }
}
