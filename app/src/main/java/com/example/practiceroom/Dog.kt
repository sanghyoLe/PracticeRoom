package com.example.practiceroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog")
class Dog(@PrimaryKey(autoGenerate = true) var id: Long?,
          @ColumnInfo(name = "dogname") var dogName: String?,
          @ColumnInfo(name = "lifespan") var lifeSpan: Int,
          @ColumnInfo(name = "origin") var origin: String
          ) {
    constructor(): this(null,"",0,"")
}