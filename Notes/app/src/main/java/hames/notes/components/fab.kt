package hames.notes.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import hames.notes.model.Note

@Composable
fun fab(navController: NavController)
{
    var adde = remember {
        mutableStateOf(false)
    }
    FloatingActionButton(onClick = {navController.navigate("add")}, containerColor = MaterialTheme.colorScheme.primary) {
        Icon(Icons.Filled.Add,null)
    }

}






