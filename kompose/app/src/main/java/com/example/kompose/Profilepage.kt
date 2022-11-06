package com.example.kompose


import android.nfc.cardemulation.CardEmulation
import androidx.compose.foundation.*
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

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
            .verticalScroll(rememberScrollState())
    )
    {
        ConstraintLayout{
            val (image,name,rowstats,butto1,butto2) = createRefs()
            val guideline = createGuidelineFromTop(0.3f)
            Image(
                painter = painterResource(id = R.drawable.wall),
                contentDescription = "cat",
                alignment = Alignment.Center,
                modifier = Modifier
                    //.padding(top = 15.dp) can be avoided by using guidline for spacing and where we have to space we have to replace in linkto with guideline
                    //guideline is more better to use than padding because it works well with constraint layout and for a small value it offers perfect spacing
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .constrainAs(image)
                    {
                        top.linkTo(guideline)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop//crops the image to fit best

            )

            Text(
                text = "Cat",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top=10.dp)
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
                    .constrainAs(rowstats)
                    {
                        top.linkTo(name.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
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

           /* Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()//takes all width
                    .padding(55.dp)
                    .constrainAs(butto)
                    {
                        top.linkTo(rowstats.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )*/
            //i dont even need row for button as i can align them directly using modifier
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .constrainAs(butto1)
                    {
                        top.linkTo(rowstats.bottom, margin = 30.dp)
                        start.linkTo(parent.start)
                        end.linkTo(butto2.start)
                       // width= Dimension.wrapContent
                    }

                )
                {
                    Text(text ="Follow User")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .constrainAs(butto2)
                    {
                        top.linkTo(rowstats.bottom, margin = 30.dp)
                        start.linkTo(butto1.end)
                        end.linkTo(parent.end)
                       //width= Dimension.wrapContent
                    }
                )
                {
                    Text(text = "Message")
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
//below function is used for previewing in the design windows
/*@Preview(showBackground = true)
@Composable
fun Profilepre()
{
    Profilepage()
}*/