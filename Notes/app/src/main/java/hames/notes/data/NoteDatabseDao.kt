package hames.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import hames.notes.model.Note
import kotlinx.coroutines.flow.Flow

@Dao//can access database
interface NoteDatabseDao {
    @Query("SELECT * from notes_table")
    fun getNotes(): Flow<List<Note>>

    @Query("select * from notes_table where id==:id")
   suspend  fun getNotebyid(id :String) : Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note : Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note:Note)

    @Query("delete from notes_table")
    suspend fun delete_all()

    @Delete
    suspend fun deleteNote(note : Note)



}