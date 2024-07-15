package com.damidu.cofeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.damidu.cofeemasters.pages.InfoPage
import com.damidu.cofeemasters.pages.MenuPage
import com.damidu.cofeemasters.pages.OfferPage
import com.damidu.cofeemasters.pages.OrderPage
import com.damidu.cofeemasters.ui.theme.CofeeMastersTheme


@Preview
@Composable
private fun App_Preview() {
    CofeeMastersTheme {
        App()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    AppTitle()
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                ),
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when(selectedRoute.value){
                    Routes.MenuPage.route -> {
                        MenuPage()
                    }
                    Routes.OfferPage.route -> {
                        OfferPage()
                    }
                    Routes.OrderPage.route -> {
                        OrderPage()
                    }
                    Routes.InfoPage.route -> {
                        InfoPage()
                    }
                }
            }
        },
        bottomBar = {
           NavBar(
               selectedRoute = selectedRoute.value,
                onChange = {
                     selectedRoute.value = it
                }
           )
        }
    )
}


@Composable
private fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "AppLogo")
    }
}