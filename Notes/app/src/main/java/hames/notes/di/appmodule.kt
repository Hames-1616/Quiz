package hames.notes.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hames.notes.data.NoteDatabase
import hames.notes.data.NoteDatabseDao
import javax.inject.Singleton
 //application class has access tp every and knows everything
//modules are used to add bindings to hilt
//to tell hilt how to provide instances of different types
//we will use a builder to create a database or in actual we dont need a database
@Module
@InstallIn(SingletonComponent::class)//
object appmodule {
    //contains all the bindings to the hilt

    @Singleton
    @Provides
    fun providenotesDao(noteDatabase: NoteDatabase) : NoteDatabseDao
    = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):NoteDatabase
    = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
    "notes_db")
        .fallbackToDestructiveMigration()
        .build()
}