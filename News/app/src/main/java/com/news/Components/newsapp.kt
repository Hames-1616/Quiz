package com.news.Components

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun newsapp()
{

}






@Composable
fun navigation()
{
    val navController = rememberNavController()
   NavHost(navController = navController, startDestination = "top" )
   {
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









