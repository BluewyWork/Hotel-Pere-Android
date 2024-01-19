package com.intermodular.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.intermodular.hotel.carrito.ui.CarritoViewModel
import com.intermodular.hotel.core.navigations.NavigationHost
import com.intermodular.hotel.registro.ui.RegistroViewModel
import com.intermodular.hotel.ui.theme.IntermodularHotelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val registroViewModel: RegistroViewModel by viewModels()
    private val carritoViewModel: CarritoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        carritoViewModel.onCreate()

        setContent {
            IntermodularHotelTheme {
                NavigationHost(registroViewModel, carritoViewModel)
            }

        }
    }
}




