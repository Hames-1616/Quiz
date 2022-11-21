package com.news.Components

import android.annotation.SuppressLint
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.news.R
import com.news.models_retro.getallcategory
import com.news.models_retro.topnewsarticle
import com.news.network.newsmanager
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun category(navController: NavController,)
{
    Scaffold(
        bottomBar = {bottom(navController)}
    ){}
    val tabitems = getallcategory()
}



@Composable
fun categorytab(category:String , selected:Boolean=false,fetch :(String) ->Unit)
{
    Surface(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 16.dp)
            .clickable {
                fetch(category)//which category was selected
            },
        shape = MaterialTheme.shapes.small,
        color= MaterialTheme.colorScheme.surfaceVariant
    ) {
        Text(
            category,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
        )

    }
}