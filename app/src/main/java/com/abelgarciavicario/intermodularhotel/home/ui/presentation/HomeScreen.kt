package com.abelgarciavicario.intermodularhotel.home.ui.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abelgarciavicario.intermodularhotel.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(topBar = { SmallTopBar() }, bottomBar = { BottomBar() }) {
        Home()
    }
}

@Composable
fun Home() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(60.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(16.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(16.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(16.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(16.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(16.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(16.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(16.dp))
            HotelCard()
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(title = {
        Row { }
    }, colors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    ), navigationIcon = {
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "menu",
                modifier = Modifier.size(100.dp)
            )
        }
    }, actions = {
        Icon(imageVector = Icons.Filled.Search,
            contentDescription = "search",
            modifier = Modifier
                .size(50.dp)
                .clickable { })
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text("Small Top App Bar")
        }
    )
}

@Composable
fun BottomBar() {
    NavigationBar {
        NavigationBarItem(selected = false, onClick = { }, label = {
            Text(
                text = "HOME"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "Home",
            )
        })
        NavigationBarItem(selected = false, onClick = { }, label = {
            Text(
                text = "BUSCAR"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
            )
        })
        NavigationBarItem(selected = false, onClick = { }, label = {
            Text(
                text = "CARRITO"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Cart",
            )
        })
        NavigationBarItem(selected = false, onClick = { }, label = {
            Text(
                text = "CUENTA"
            )
        }, icon = {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Person",
                modifier = Modifier.size(40.dp)
            )
        })
    }
}

@Composable
fun HotelCard() {
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
            Image(
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription = "Restaurant Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Sample Text",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
