package hames.notes.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import hames.notes.data.notessource
import hames.notes.model.Note

class NoteViewModel : ViewModel() {

   private var notelist = mutableStateListOf<Note>()
    //live notes

    init {
        notelist.addAll(notessource().loadnotes())
        //loads all the notes data present
    }

    fun addNote(note: Note)
    {
        notelist.add(note)
        //adds the notelist that we create to the note data
    }
    fun removeNote(note: Note)
    {
        notelist.remove(note)
        //removes the notelist that we want to delete from the note data
    }

    fun getnotes() : List<Note>
    {
        return notelist
        //get all the notes that we create
    }
}