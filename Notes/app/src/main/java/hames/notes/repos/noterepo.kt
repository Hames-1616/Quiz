package hames.notes.repos

import hames.notes.data.NoteDatabseDao
import hames.notes.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class noterepo @Inject constructor(private val databseDao: NoteDatabseDao) {
    suspend fun addnote(note : Note) = databseDao.insert(note)

    suspend fun update(note: Note) = databseDao.update(note)

    suspend fun delete(note: Note) = databseDao.deleteNote(note)

    suspend fun deleteall() = databseDao.delete_all()

    suspend fun getall() : Flow<List<Note>> = databseDao.getNotes().flowOn(Dispatchers.IO)
        .conflate()
}