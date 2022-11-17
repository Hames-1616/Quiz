package com.news.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.news.news

@Composable
fun top(navController: NavController)
{
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        topheader()
       /* Button(onClick = {navController.navigate("detail")}) {
            Text(text = "Go to the detail screen")
        }*/
        LazyColumn{
            items(mockdata.topnewslist)
            {
                newsdata ->

                topnews(newsdata, onnewsclick = {
                    navController.navigate("detail/${newsdata.id}")
                })
            }
        }
        
    }
}
@Composable
fun topnews(newsdata: newsdata,onnewsclick: ()-> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .border(8.dp, MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(20.dp),)
    ) {

        Row(modifier = Modifier
            .height(200.dp)
            .padding(6.dp)
            .border(1.dp, MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(3.dp))
            .clickable {
                onnewsclick()
            }
        ) {
            Image(
                painter = painterResource(id = newsdata.image), contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
            )
            {
                Text(text = newsdata.title, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

}

