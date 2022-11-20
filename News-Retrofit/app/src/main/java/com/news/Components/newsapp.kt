package com.news.Components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.news.models_retro.topnewsarticle
import com.news.network.newsmanager


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
fun navigation(navController: NavHostController,scrollState: ScrollState,newsmanager: newsmanager = newsmanager()) {

    val articles = newsmanager.newsresponse.value.articles
    Log.d("news", "${articles}")
    articles?.let {
        NavHost(navController, startDestination = bottomnav.Topnews.route)
        {
            bottom(navController, articles)
            composable("detail/{index}",
                arguments = listOf(
                    navArgument("index")
                    {
                        type = NavType.IntType
                    }
                )
            )
            { NavBackStackEntry ->
                val index = NavBackStackEntry.arguments?.getInt("index")
                index?.let {
                    val article = articles[index]
                    detail(article, navController)
                }

            }
        }
    }
}


fun NavGraphBuilder.bottom(navController: NavController,articles:List<topnewsarticle>)
{
    composable(
        bottomnav.Topnews.route
    )
    {
         top(navController = navController, articles)
    }
    composable(bottomnav.Category.route)
    {
        category(navController,articles[1])
    }
    composable(bottomnav.About.route)
    {
        about(navController)
    }
}









