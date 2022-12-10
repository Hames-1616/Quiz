package hames.notes.components

import androidx.room.TypeConverter
import java.sql.Timestamp
import java.util.Date

class dateCon {
    @TypeConverter
    fun timeStampfromdate(date : Date) : Long{
        return date.time
    }
    @TypeConverter
    fun dateTimestamp(timestamp: Long) : Date?
    {
        return (Date(timestamp))
    }
}