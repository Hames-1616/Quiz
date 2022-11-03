package first.compose

import android.app.Notification.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import first.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Haamid")//for text in app
                   // myapp()
                    Profilepage()
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
    ComposeTheme {
       // Greeting("text in preview")//for text in preview
       // myapp()
    }
}