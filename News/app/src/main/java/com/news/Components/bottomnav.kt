package com.news.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class bottomnav (
    val route : String,
    val icon : ImageVector,
    val title : String
    )
{
    object Topnews : bottomnav(
        "top",
        Icons.Filled.Home,
        "Top News"
    )
    object Category : bottomnav(
        "Categories",
        Icons.Filled.Category,
        "Category"
    )
    object About : bottomnav(
        "About",
        Icons.Filled.ContactPage,
        "About"
    )

}