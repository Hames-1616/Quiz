package com.news.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun category(navController: NavController)
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