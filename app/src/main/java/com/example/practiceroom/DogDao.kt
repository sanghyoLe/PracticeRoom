package com.example.practiceroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface DogDao {
   @Query("SELECT * FROM dog")
   fun getAll(): List<Dog>

    @Insert(onConflict = REPLACE)
    fun insert(dog: Dog)

    @Query("DELETE FROM dog")
    fun deleteAll()
}