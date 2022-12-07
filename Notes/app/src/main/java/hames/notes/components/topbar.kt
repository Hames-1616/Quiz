package hames.notes.components

import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import hames.notes.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun top(scrollBehavior: TopAppBarScrollBehavior)
{

    TopAppBar(scrollBehavior=scrollBehavior, title = { Text(text = "Notes")},
        actions = {IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Search,null)
        }})
    /*Box{
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(250.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp)
            )
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                    ){
                Text(text = "Notes", modifier = Modifier
                    .padding(start=20.dp,top=40.dp), textAlign = TextAlign.Left,
                fontSize = 100.sp, style=MaterialTheme.typography.displayMedium)
            }
                Column(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Rounded.Search, null)
                }
                }


        }
    }*/
}


