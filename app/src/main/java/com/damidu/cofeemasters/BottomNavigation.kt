package com.damidu.cofeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.damidu.cofeemasters.ui.theme.Alternative2
import com.damidu.cofeemasters.ui.theme.OnPrimary
import com.damidu.cofeemasters.ui.theme.Primary

data class  NavPage(var name : String  , var icon : ImageVector , var route : String)

object Routes {
    val MenuPage = NavPage("Menu" , Icons.Default.Menu , "menu")
    val OfferPage = NavPage("Offers" , Icons.Default.Star , "offers")
    val OrderPage = NavPage("Orders" , Icons.Default.ShoppingCart , "orders")
    val InfoPage = NavPage("Info" , Icons.Default.Info , "info")

    val pages = listOf(MenuPage , OfferPage , OrderPage , InfoPage)
}

@Preview
@Composable
fun NavBar(
    selectedRoute : String = Routes.MenuPage.route ,
    onChange : (String) -> Unit = {}
) {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Primary)
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Routes.pages.forEach { page ->
            NavBarItem(
                selected = page.route == selectedRoute,
                page = page,
                modifier = Modifier
                    .clickable {
                        onChange(page.route)
                    },
            )
        }
    }
}

@Composable
fun NavBarItem(modifier: Modifier = Modifier , page: NavPage , selected : Boolean = false) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 12.dp)
    ) {
        Image(
            imageVector = page.icon ,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Alternative2 else OnPrimary
            ),
            modifier = Modifier
                .padding(4.dp)
                .size(27.dp)
        )
        Text(
            text = page.name,
            fontSize = 12.sp,
            color = if (selected) Alternative2 else OnPrimary
        )
    }

}