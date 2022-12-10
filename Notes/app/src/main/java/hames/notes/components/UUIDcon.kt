package hames.notes.components

import androidx.room.TypeConverter
import java.util.UUID

class UUIDcon {
    @TypeConverter
    fun fromuuid(uuid: UUID) : String {
        return uuid.toString()
    }
    @TypeConverter
    fun uuidfromstring(string: String?) : UUID?
    {
        return UUID.fromString(string)
    }
}