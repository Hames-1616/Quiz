package hames.notes.data

import hames.notes.model.Note

class notessource{
    fun loadnotes (): List<Note>{
        return listOf(
            Note(title = "hey there", description = "what a busy day"),
            )
    }
}