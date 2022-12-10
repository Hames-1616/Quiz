package hames.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hames.notes.components.UUIDcon
import hames.notes.components.dateCon
import hames.notes.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(dateCon::class,UUIDcon::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDatabseDao
}