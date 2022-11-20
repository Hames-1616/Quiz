package com.news.Components

import android.widget.TextView.SavedState
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.isPopupLayout
import androidx.navigation.NavController
import androidx.navigation.compose.*
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun bottom(navController: NavController)
{
    val menuitems = listOf(bottomnav.Topnews,bottomnav.Category,bottomnav.About)

    NavigationBar (
        modifier = Modifier.requiredHeight(75.dp)
            ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()//detects current page
        val currentRoute = navBackStackEntry?.destination?.route//shows color when selected
        menuitems.forEach{
            NavigationBarItem(
                selected = currentRoute==it.route,
                onClick = {
                          navController.navigate(it.route)
                },
                icon = {Icon(it.icon,null, modifier = Modifier.size(23.dp))},
                label = {Text(it.title, fontSize = 10.sp)}
            )
        }
    }
}
