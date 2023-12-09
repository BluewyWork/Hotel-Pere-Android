package com.abelgarciavicario.intermodularhotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.abelgarciavicario.intermodularhotel.registro.ui.RegistroViewModel
import com.abelgarciavicario.intermodularhotel.navigations.NavigationHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val registroViewModel: RegistroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost(registroViewModel)
        }
    }
}




