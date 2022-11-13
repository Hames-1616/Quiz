package com.example.emailui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun lazy(padding:PaddingValues)
{
    Box(modifier = Modifier.padding(padding))
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            items(mock){
                outline->
                design(outline)
            }

        }
    }
}

@Composable
fun design(outline: outline)
{
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            ){
        Card(modifier = Modifier
            .padding(end = 8.dp)
            .size(40.dp)
            .clip(CircleShape)
            .background(Color.Gray)
        ) {
            Text(
                text=outline.username[0].toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 7.dp)
                    .padding(8.dp)

            )
        }
        Column(
            modifier = Modifier
                .weight(2.0f)
        )
        {
            Text(
                text = outline.username,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = outline.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = outline.body,
                fontSize = 14.sp,
            )

        }
        Column() {
            Text(text = outline.stamp)
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 16.dp)
            ) {

                Icon(imageVector = Icons.Filled.StarOutline,null)
            }
        }
    }
}




