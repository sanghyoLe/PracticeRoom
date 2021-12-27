package com.example.practiceroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Dog::class], version = 1)
abstract class DogDB : RoomDatabase(){
    abstract fun dogDao(): DogDao

    companion object {
        private var INSTANCE: DogDB? = null

        fun getInstance(context: Context): DogDB? {
            if(INSTANCE == null){
                synchronized(DogDB::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DogDB::class.java, "dog")
                        .fallbackToDestructiveMigration()
                        .build()

                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}