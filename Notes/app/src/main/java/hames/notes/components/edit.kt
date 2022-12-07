package hames.notes.components

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import hames.notes.model.Note
var flag : Int = 0
@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun edit(navController: NavController, onAdd: (Note) -> Unit, tit: String?, des: String?){
    val context = LocalContext.current
    flag = 0
    var title by remember {
        mutableStateOf("$tit")
    }
    var note by remember { mutableStateOf("$des") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    )
    {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, null, modifier = Modifier)
            //.align(Alignment.Start))
        }
        IconButton(onClick = {
            onAdd(Note(title = title, description = note))
            title = ""
            note = ""
            Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
            flag = 1
            navController.popBackStack()
        }) {
            if (title.isNotEmpty() && note.isNotEmpty())
                Icon(
                    Icons.Filled.Done, null, modifier = Modifier.align(CenterVertically)
                    //.align(Alignment.End)
                )

        }

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    )

    {
        Spacer(modifier = Modifier.height(70.dp))
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Title") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent

            ),
            modifier = Modifier
                .padding(start = 15.dp)
                .fillMaxWidth()
        )
        TextField(
            value = note,
            onValueChange = { note = it },
            label = { Text(text = "Description") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent

            ),
            modifier = Modifier
                .padding(start = 15.dp)
                .fillMaxWidth()
        )
    }
}

fun getflag():Int
{
    return flag
}