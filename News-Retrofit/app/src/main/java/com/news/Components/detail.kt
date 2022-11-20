package com.news.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.news.R
import com.news.models_retro.topnewsarticle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun detail(article:topnewsarticle, navController: NavController)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        header(navController)
            Column{

                Card(modifier = Modifier
                    .padding(10.dp)
                    .border(
                        5.dp,
                        MaterialTheme.colorScheme.surfaceVariant,
                        RoundedCornerShape(21.dp)
                    )) {
                    CoilImage(
                        modifier = Modifier
                            .border(
                                6.dp,
                                MaterialTheme.colorScheme.surfaceVariant,
                                RoundedCornerShape(10.dp)
                            ),
                        imageModel = {article.urlToImage},
                        imageOptions = ImageOptions(
                            requestSize = IntSize(1024,700),
                            alignment = Alignment.Center

                        ),
                        failure = {ImageBitmap.imageResource(id = R.drawable.back)}
                    )
                }
                    Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    info(Icons.Filled.Edit,article.author?:"Not available",Icons.Filled.DateRange,article.publishedAt!!)
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)

                ) {


                    Text(
                        text = article.description!!,
                        modifier = Modifier.padding(top = 25.dp, end = 25.dp, start = 15.dp, bottom = 20.dp),
                        textAlign = TextAlign.Justify
                    )
                }
            }

            }

    }


@Composable
fun info(icon : ImageVector , info:String , icone:ImageVector , time:String)
{
    Box(
        //modifier = Modifier.padding(10.dp)
    )
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .requiredHeight(50.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 6.dp),
           // shape = RoundedCornerShape(50.dp)

        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            ) {
                Icon(
                    icon, "Auhor",
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
                Text(text = info, fontSize = 15.sp)

                Icon(icone,"date",
                modifier = Modifier.padding(start=149.dp,end=8.dp))

                Text(text = time, fontSize = 15.sp)
            }
        }
    }
}

