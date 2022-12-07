package hames.notes.navigation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hames.notes.components.add
import hames.notes.components.edit
import hames.notes.model.Note
import hames.notes.screen.NoteViewModel
import hames.notes.screen.notescreen
var s : Int = 0
@Composable
fun notenavigation(

    onAdd: (Note) -> Unit,
    onRemove: (Note) -> Unit,
    viewmodel: NoteViewModel,
    notes: List<Note>
)
{


    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "notesscreen")
    {
        composable("notesscreen")
        {

            notescreen(navController,notes,onRemove={viewmodel.removeNote(it)})
        }

        composable("add")
        {
            add(navController,onAdd = {viewmodel.addNote(it)})
        }

        composable("edit/{s}/{r}")
        {
            NavBackStackEntry ->
            val title = NavBackStackEntry.arguments?.getString("s")
            val description = NavBackStackEntry.arguments?.getString("r")
           edit(navController, onAdd = {viewmodel.addNote(it)},title,description)

        }

    }
}

@Composable
fun notesapp(viewmodel : NoteViewModel = viewModel())
{
    val notes = viewmodel.getnotes()
    notenavigation(onAdd = {}, onRemove ={},viewmodel,notes)
}
