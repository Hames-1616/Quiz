package com.news.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.news.R
import com.news.models_retro.topnewsarticle
import com.news.models_retro.topnewsresponse
import com.news.news
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.ImageComponent
import com.skydoves.landscapist.components.imageComponent
import com.skydoves.landscapist.glide.GlideImage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun top(navController: NavController,articles: List<topnewsarticle>)
{
    Scaffold(
        topBar = { topheader()},
        bottomBar = {bottom(navController)}
    ) {

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 69.dp, top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
       /* Button(onClick = {navController.navigate("detail")}) {
            Text(text = "Go to the detail screen")
        }*/
        LazyColumn{
            items(articles.size)
            {
                index ->

                topnews(article=articles[index],
                    onnewsclick = {
                        navController.navigate("detail/$index")
                    }
                )
            }
        }

        
    }
}
@Composable
fun topnews(article:topnewsarticle,onnewsclick: ()-> Unit = {}) {

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
            CoilImage(
                imageModel = { article.urlToImage },
                imageOptions = ImageOptions(
                    requestSize = IntSize(1920,1080),
                    alignment = Alignment.Center
                ),
                //failure = {ImageBitmap.imageResource(R.drawable.back)},

                )

        }

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
            )
            {
                Text(text = article.title!!, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        }


