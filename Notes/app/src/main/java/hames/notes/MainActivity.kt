package hames.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import hames.notes.components.add
import hames.notes.navigation.notenavigation
import hames.notes.navigation.notesapp
import hames.notes.screen.NoteViewModel
import hames.notes.screen.notescreen
import hames.notes.ui.theme.NotesTheme
@AndroidEntryPoint//this is a dependency container
//so we can get all the dependencies needed or we have access to all the dependencies in the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewmodel : NoteViewModel by viewModels()
                    notesapp(viewmodel)
                }
            }
        }
    }
}

