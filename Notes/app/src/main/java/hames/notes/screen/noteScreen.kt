package hames.notes.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hames.notes.components.fab
import hames.notes.components.getflag
import hames.notes.components.top
import hames.notes.model.Note


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun notescreen(navController: NavController, notes: List<Note>, onRemove: (Note) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val context = LocalContext.current

    //top()
    //there is another way of doing that without scaffold
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp))

    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = { top(scrollBehavior) },
            floatingActionButton = { fab(navController) }
        ) {
            LazyColumn(modifier = Modifier.padding(top = 60.dp)) {
                items(notes, key = { note -> note.id }) { note ->

                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .requiredHeight(110.dp)
                            .clickable {
                                onRemove(note)
                                     Toast.makeText(context,"Note Deleted",Toast.LENGTH_SHORT).show()},
                              // val s = note.title
                                //val r = note.description

                                //navController.navigate("edit/${s}/${r}")
/*
                                if ("$s$r" == "$note.title${note.description}") {
                                    onRemove(note)
                                }
                                       val x = getflag()
                                if(x==1)
                                {
                                    onRemove(note)
                                }
                                */
                        shape = RoundedCornerShape(15.dp)
                    )
                    {
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(
                                text = note.title,
                                style = MaterialTheme.typography.displayLarge,
                                fontSize = 22.sp
                            )
                            Text(
                                text = note.description,
                                style = MaterialTheme.typography.displaySmall,
                                fontSize = 18.sp
                            )
                            Text(
                                text = note.time.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                fontSize = 13.sp
                            )

                        }
                    }
                }
            }
        }
    }
}




