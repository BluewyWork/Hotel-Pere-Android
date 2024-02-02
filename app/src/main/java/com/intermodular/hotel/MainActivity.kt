package com.intermodular.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.intermodular.hotel.cart.ui.CartViewModel
import com.intermodular.hotel.core.navigations.NavigationHost
import com.intermodular.hotel.home.ui.HomeViewModel
import com.intermodular.hotel.login.ui.LoginViewModel
import com.intermodular.hotel.profile.ui.ProfileViewModel
import com.intermodular.hotel.registro.ui.RegistroViewModel
import com.intermodular.hotel.reservationsOverview.ui.ReservationsOverviewViewModel
import com.intermodular.hotel.ui.theme.IntermodularHotelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val registroViewModel: RegistroViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()
    private val cartViewModel: CartViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    private val profileViewModel: ProfileViewModel by viewModels()
    private val reservationsOverviewViewModel: ReservationsOverviewViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartViewModel.onCreate()
        homeViewModel.onCreate()
        profileViewModel.onCreate()
        reservationsOverviewViewModel.onCreate()

        setContent {
            IntermodularHotelTheme {
                NavigationHost(
                    registroViewModel,
                    cartViewModel,
                    homeViewModel,
                    loginViewModel,
                    profileViewModel,
                    reservationsOverviewViewModel
                )
            }

        }
    }
}




