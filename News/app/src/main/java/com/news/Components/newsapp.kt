package com.news.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun newsapp()
{
    val scroll = rememberScrollState()
    val nav = rememberNavController()
    mainscreen(nav,scroll)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun mainscreen(navController : NavHostController,scrollState: ScrollState)
{
        navigation(navController,scrollState)

}


@Composable
fun navigation(navController: NavHostController,scrollState: ScrollState)
{

   NavHost(navController, startDestination = "top" )
   {
       bottom(navController)
       composable("top")
       {
           top(navController)
       }
       composable("detail/{newsid}",
           arguments = listOf(
               navArgument("newsid")
               {
                   type = NavType.IntType
               }
           )
       )
       {
           NavBackStackEntry->
           val id = NavBackStackEntry.arguments?.getInt("newsid")
           val newsdata = mockdata.getnews(id)
           detail(newsdata,navController)
       }
   }
}


fun NavGraphBuilder.bottom(navController: NavController)
{
    composable(
        bottomnav.Topnews.route
    )
    {
         top(navController = navController)
    }
    composable(bottomnav.Category.route)
    {
        category(navController)
    }
    composable(bottomnav.About.route)
    {
        about(navController)
    }
}









