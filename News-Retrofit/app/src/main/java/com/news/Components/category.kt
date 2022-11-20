package com.news.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.news.R
import com.news.models_retro.topnewsarticle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun category(navController: NavController,articles : topnewsarticle)
{
    Scaffold(
        bottomBar = {bottom(navController)}
    ){}
    Text(
        "Adding soon",
        fontSize = 50.sp,
        modifier = Modifier.fillMaxWidth()
    )
}