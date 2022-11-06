package com.example.kompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kompose.ui.theme.KomposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Haamid")//for text in app
                    // myapp()
                    port_land()
                }
            }
        }
    }
}

/*@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        color = Color(red=55,green=44, blue = 922)
    )
}

@Composable
fun myapp(){
    Text(
        text = "welcome",
        color = Color.White,
        fontFamily = FontFamily.SansSerif,
        fontSize = 39.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,

    )
}*/

@Preview(showBackground = false)//turning this off will not show the bg and it will be transparent
@Composable
fun DefaultPreview() {
    KomposeTheme {
        // Greeting("text in preview")//for text in preview
        // myapp()
    }
}