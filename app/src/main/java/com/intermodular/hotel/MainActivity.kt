package com.intermodular.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.intermodular.hotel.core.navigations.NavigationHost
import com.intermodular.hotel.presentation.screens.cart.CartViewModel
import com.intermodular.hotel.presentation.screens.home.HomeViewModel
import com.intermodular.hotel.presentation.screens.login.LoginViewModel
import com.intermodular.hotel.presentation.screens.profile.ProfileViewModel
import com.intermodular.hotel.presentation.screens.register.RegisterViewModel
import com.intermodular.hotel.presentation.screens.reservationsOverview.ReservationsOverviewViewModel
import com.intermodular.hotel.ui.theme.IntermodularHotelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val registerViewModel: RegisterViewModel by viewModels()
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
                    registerViewModel,
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




