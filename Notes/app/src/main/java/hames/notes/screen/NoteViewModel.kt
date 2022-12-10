package hames.notes.screen

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import hames.notes.data.notessource
import hames.notes.model.Note
import hames.notes.repos.noterepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository:noterepo) : ViewModel() {

   private val _notelist = MutableStateFlow<List<Note>>(emptyList())
    //live notes

    val notelist = _notelist.asStateFlow()
    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getall().distinctUntilChanged()
                .collect{
                    listofnotes ->
                    if(listofnotes.isNullOrEmpty())
                    {
                        Log.d(TAG, "Empty")
                    }
                    else
                        _notelist.value = listofnotes
                }
        }
    }

     fun addNote(note: Note) = viewModelScope.launch { repository.addnote(note)}

     fun updateNote(note: Note) = viewModelScope.launch { repository.update(note)}

     fun removeNote(note: Note) = viewModelScope.launch { repository.delete(note)}

}