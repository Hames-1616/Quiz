package com.example.emailui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emailui.ui.theme.EmailUITheme
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.Painter
import com.example.emailui.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homeappbar(drawer:DrawerState,scope:CoroutineScope){
    Box(
        modifier = Modifier
            .padding(10.dp)
    ){
        Card(
            shape = RoundedCornerShape(50.dp),
            elevation = CardDefaults.cardElevation
                (
                defaultElevation = 6.dp
            ),
        modifier = Modifier
            .requiredHeight(50.dp)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
            {
                IconButton(onClick = {
                    scope.launch{
                        drawer.open()
                    }
                })
                {
                    Icon(Icons.Rounded.Menu,contentDescription = "Menu")
                }

                Text(
                    text = "Emails",
                    modifier = Modifier
                        .weight(2.0f)
                        .padding(bottom =2.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.pngegg),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Gray
                        )
                )

            }


        }
    }
}


/*
@Preview
@Composable
fun pre()
{

   Homeappbar()
}*/