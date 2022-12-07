package hames.notes.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//modules are used to add bindings to hilt
//to tell hilt how to provide instances of different types
//we will use a builder to create a database or in actual we dont need a database
@Module
@InstallIn(SingletonComponent::class)//
object appmodule {
    //contains all the bindings to the hilt
}