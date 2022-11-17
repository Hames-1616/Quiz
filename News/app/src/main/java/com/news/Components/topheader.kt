package com.news.Components

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Topic
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun topheader()
{
    Box(
        modifier = Modifier.padding(10.dp)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(50.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            shape = RoundedCornerShape(50.dp)
        ){
            Row (
                verticalAlignment = CenterVertically,
                modifier = Modifier.padding(8.dp)
                       .fillMaxSize()
            ){
                Icon(Icons.Filled.Newspaper,null, modifier = Modifier.padding(start=4.dp))
                Text(text = "Monuments",
                modifier = Modifier.weight(2.0f)
                    .padding(start=150.dp))
            }
        }
    }

}




@Preview
@Composable
fun disp()
{
    topheader()
}