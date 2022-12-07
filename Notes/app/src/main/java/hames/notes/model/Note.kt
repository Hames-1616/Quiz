package hames.notes.model


import java.util.*

data class Note (
    val id : UUID = UUID.randomUUID(),
    val title : String,
    val description : String,
    val time: Date = Calendar.getInstance().time
)
