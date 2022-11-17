package com.news.Components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun header(navController: NavController)
{
    Box(
        modifier = Modifier.padding(10.dp)
    ) {
        Card(
            modifier = Modifier
                .requiredHeight(50.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            shape = RoundedCornerShape(50.dp)
        ) {
            Row(

                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()

            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowLeft, null)

                }
                Text(text = "Details", modifier = Modifier.weight(2.0f).padding(start=150.dp))
            }
        }
    }
}
