package com.abelgarciavicario.intermodularhotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abelgarciavicario.intermodularhotel.navigations.NavigationHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           NavigationHost()
        }
    }
}


//@Preview(showBackground = true)
//@Composable
