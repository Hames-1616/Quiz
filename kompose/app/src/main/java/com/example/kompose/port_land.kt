package com.example.kompose


import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Icon
import android.nfc.cardemulation.CardEmulation
import android.widget.Toast
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.widget.ConstraintSet.Constraint

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun port_land() {
    if (res() == "port") {
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
            BoxWithConstraints() {

                val constraints = port(33.dp)


                //the set coming from the particular function will be used here
                ConstraintLayout(constraints) {

                    Image(
                        painter = painterResource(id = R.drawable.wall),
                        contentDescription = "cat",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            //.padding(top = 15.dp) //can be avoided by using guidline for spacing and where we have to space we have to replace in linkto with guideline
                            //guideline is more better to use than padding because it works well with constraint layout and for a small value it offers perfect spacing
                            .size(200.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                            .layoutId("image"),
                        contentScale = ContentScale.Crop//crops the image to fit best

                    )

                    Text(
                        text = "Cat",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .layoutId("name")
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 55.dp)
                            .layoutId("rowstats")
                    )
                    {
                        Column(horizontalAlignment = Alignment.CenterHorizontally)
                        {
                            Text(
                                text = "150",
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Followers",
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
                        prostate(num = "77", title = "Interactions ❤‍")
                    }
                    //since we are again and again creating same code so lets make a function for it

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.layoutId("butto1")

                    )
                    {
                        Text(text = "Follow User")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.layoutId("butto2")

                    )
                    {
                        Text(text = "Message")
                    }


                    //some text
                    var text by rememberSaveable() {
                        mutableStateOf("")
                    }
                    /*
                    var password by rememberSaveable { mutableStateOf("") }
                    var passwordHidden by rememberSaveable { mutableStateOf(true) }*/

                    OutlinedTextField(
                        value = text,
                        onValueChange = {text=it},
                        label = {Text("Feedback")},
                        shape = RoundedCornerShape(200.dp),
                        placeholder = {Text("enter your feedback")},//displaying that hint text
                        singleLine = true,
                        leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "fav") },
                        trailingIcon = {
                            IconButton(onClick = {text=""})
                                {
                                    val disicon = if(text.isEmpty()) Icons.Outlined.MoreVert else Icons.Filled.Close
                                    val des = if(text.isEmpty()) null else "data"
                                    if(text.isNotEmpty())
                                        Icon(imageVector = disicon, contentDescription = des)
                                }
                                       },
                        modifier = Modifier
                            .layoutId("boxx")


                        //
                    )
                    val mContext = LocalContext.current
                    if(text.isNotEmpty())
                    Button(
                        onClick = {
                                    text=""
                                    mToast(mContext)
                                  },
                        modifier = Modifier
                            .layoutId("submit"),
                           //Toast.makeText(this,"submitted",Toast.LENGTH_SHORT).show()

                    ) {
                        Text(
                            text = "Submit"
                        )
                    }
                    //below textfield code is for password reffer to original compose material webiste for more
                       /* value = password,
                        onValueChange = { password = it },
                        singleLine = true,
                        label = { Text("Enter password") },
                        visualTransformation =
                        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                                val visibilityIcon =
                                    if (passwordHidden) Icons.Filled.Info else Icons.Outlined.Info
                                // Please provide localized description for accessibility services
                                val description = if (passwordHidden) "Show password" else "Hide password"
                                Icon(imageVector = visibilityIcon, contentDescription = description)
                            }
                        }


                    )*/

                }
            }
        }
    } else {
        Card(
            elevation = CardDefaults.cardElevation
                (
                defaultElevation = 8.dp,
            ),

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 50.dp, start = 16.dp, end = 16.dp)
                .border(width = 2.dp, color = Color(160, 82, 45), shape = RoundedCornerShape(8.dp))

        )


        {
            BoxWithConstraints() {

                val constraints = land(margin = 16.dp)


                //the set coming from the particular function will be used here
                ConstraintLayout(constraints) {

                    Image(
                        painter = painterResource(id = R.drawable.wall),
                        contentDescription = "cat",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .padding(10.dp) //can be avoided by using guidline for spacing and where we have to space we have to replace in linkto with guideline
                            //guideline is more better to use than padding because it works well with constraint layout and for a small value it offers perfect spacing
                            .size(180.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                            .layoutId("image"),
                        contentScale = ContentScale.Crop//crops the image to fit best

                    )

                    Text(
                        text = "Cat",
                        //textAlign = TextAlign.Start,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier

                            .layoutId("name")
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 55.dp)
                            .layoutId("rowstats")
                    )
                    {
                        prostate(num = "29", title = "Following")
                        prostate(num = "200", title ="Followers" )
                        prostate(num = "300", title = "Post")
                        prostate(num = "77", title = "Interactions ❤‍")
                    }
                    //since we are again and again creating same code so lets make a function for it

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.layoutId("butto1")

                    )
                    {
                        Text(text = "Follow User")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.layoutId("butto2")

                    )
                    {
                        Text(text = "Message")
                    }

                   /* Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth(),

                    ) {

                    }*/

                   /* var text by rememberSaveable(){
                        mutableStateOf("")
                    }

                    TextField(
                        value = text,
                        onValueChange ={ text=it },
                        label = {Text("Label")},
                        singleLine = true
                    )

                    */


                }
            }
        }
    }
}
//function for determining the rotation currently
@Composable
fun res() : String {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            return "land"
        }
        else -> {
            return "port"
        }
    }
}
@Composable
fun prostate(num:String , title:String)
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
private fun mToast(context: Context){
    Toast.makeText(context, "Submitted successfully", Toast.LENGTH_LONG).show()
}
//so we will create funtion for portrait and landscape modes
//but before doing port and land we have to make sure our constraint stay in something like a box
private fun port(margin:Dp) : ConstraintSet{
    return ConstraintSet {
        val image = createRefFor("image")
        val name = createRefFor("name")
        val rowstats = createRefFor("rowstats")
        val butto1 = createRefFor("butto1")
        val butto2 =createRefFor("butto2")
        val boxx = createRefFor("boxx")
        val submit = createRefFor("submit")
        val guideline = createGuidelineFromTop(0.06f)

        constrain(image){
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(name){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowstats){
            top.linkTo(name.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(butto1){
            top.linkTo(rowstats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(butto2.start)
            width= Dimension.wrapContent
        }
        constrain(butto2){
            top.linkTo(rowstats.bottom, margin = margin)
            start.linkTo(butto1.end)
            end.linkTo(parent.end)
            width=Dimension.wrapContent
        }
        constrain(boxx){
            top.linkTo(butto1.bottom,margin=margin)
            top.linkTo(butto2.bottom,margin=margin)
            start.linkTo(parent.start,margin=margin)
            end.linkTo(parent.end,margin=margin)

        }
        constrain(submit){
            top.linkTo(boxx.bottom,margin=margin)
            start.linkTo(parent.start,margin=margin)
            end.linkTo(parent.end,margin=margin)
        }
    }
}

private fun land(margin : Dp) : ConstraintSet{
    return ConstraintSet{
        val image = createRefFor("image")
        val name = createRefFor("name")
        val rowstats = createRefFor("rowstats")
        val butto1 = createRefFor("butto1")
        val butto2 =createRefFor("butto2")
        val guideline = createGuidelineFromTop(0.1f)

        constrain(image){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }
        constrain(name){
            top.linkTo(image.bottom)
            start.linkTo(parent.start,margin=67.dp)
            //end.linkTo(parent.end)

        }
        constrain(rowstats){
            top.linkTo(parent.top)
            start.linkTo(image.end,margin=margin)
            end.linkTo(parent.end)
        }
        constrain(butto1){
            top.linkTo(rowstats.bottom,margin=33.dp)
            start.linkTo(rowstats.start)
            end.linkTo(butto2.start)
            bottom.linkTo(name.bottom)

        }
        constrain(butto2){
            top.linkTo(rowstats.bottom,margin=33.dp)
            start.linkTo(butto1.end,margin=margin)
            end.linkTo(parent.end)
            bottom.linkTo(name.bottom)

        }

    }

}


@Preview(showBackground = true)
@Composable
fun pre()
{
    port_land()
}