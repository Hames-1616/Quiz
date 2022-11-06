                package first.compose

                import android.nfc.cardemulation.CardEmulation
                import androidx.compose.foundation.Image
                import androidx.compose.foundation.border
                import androidx.compose.foundation.layout.*
                import androidx.compose.foundation.shape.CircleShape
                import androidx.compose.runtime.Composable
                import androidx.compose.ui.Alignment
                import androidx.compose.ui.Modifier
                import androidx.compose.ui.draw.clip
                import androidx.compose.ui.graphics.Color
                import androidx.compose.ui.graphics.Shape
                import androidx.compose.ui.layout.ContentScale
                import androidx.compose.ui.modifier.modifierLocalOf
                import androidx.compose.ui.res.painterResource
                import androidx.compose.ui.text.font.FontWeight
                import androidx.compose.ui.text.style.TextAlign
                import androidx.compose.ui.tooling.preview.Preview
                import androidx.compose.ui.unit.dp
                import androidx.compose.ui.unit.sp
                import androidx.compose.foundation.layout.size
                import androidx.compose.foundation.rememberScrollState
                import androidx.compose.foundation.shape.RoundedCornerShape
                import androidx.compose.foundation.verticalScroll
                import androidx.compose.material3.*
                import androidx.constraintlayout.compose.ConstraintLayout

                @Composable
                fun Profilepage(){
                    Card(
                        elevation = CardDefaults.cardElevation
                            (
                               defaultElevation = 8.dp,
                            ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
                            .border(width = 2.dp, color = Color(160, 82, 45), shape = RoundedCornerShape(8.dp))

                    )
                    {
                            ConstraintLayout{
                                val (image,name) = createRefs()
                                Image(
                                    painter = painterResource(id = R.drawable.wall),
                                    contentDescription = "cat",
                                    alignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .clip(CircleShape)
                                        .border(
                                            width = 2.dp,
                                            color = Color.White,
                                            shape = CircleShape
                                        )
                                        .constrainAs(image)
                                        {
                                           top.linkTo(parent.top)
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)
                                        },
                                    contentScale = ContentScale.Crop//crops the image to fit best

                                )

                                Text(
                                    text = "Hames",
                                    textAlign = TextAlign.Center,
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .constrainAs(name)
                                        {
                                         top.linkTo(image.bottom)
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)
                                        }

                                )

                                Row(
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 55.dp)
                                )
                                {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally)
                                    {
                                        Text(
                                            text = "250",
                                            fontWeight = FontWeight.Bold,
                                        )
                                        Text(
                                            text ="Followers",
                                            fontWeight = FontWeight.Light,
                                        )
                                    }
                                    Column(horizontalAlignment = Alignment.CenterHorizontally)
                                    {
                                        Text(
                                            text = "25",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Following",
                                            fontWeight = FontWeight.Light
                                        )
                                    }
                                    Column(horizontalAlignment = Alignment.CenterHorizontally)
                                    {
                                        Text(
                                            text = "300",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Posts",
                                            fontWeight = FontWeight.Light
                                        )
                                    }
                                    prostat(num = "77", title ="Interactions ❤‍" )
                                }
                                //since we are again and again creating same code so lets make a function for it

                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(55.dp)
                                )
                                {
                                    Button(onClick = { /*TODO*/ })
                                    {
                                        Text(text ="Follow User")
                                    }
                                    Button(onClick = { /*TODO*/ })
                                    {
                                        Text(text = "Message")
                                    }
                                }
                            }


                    }
                }

                @Composable
                fun prostat(num:String , title:String)
                {//with this function it will be very easy to get the column make with just 2 fields
                    Column(horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Text(
                            text = num,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = title,
                            fontWeight = FontWeight.Light
                        )
                    }
                }

                @Preview(showBackground = true)
                @Composable
                fun Profilepre()
                {
                    Profilepage()
                }