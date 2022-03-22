package com.example.daniwebandroidroomtransaction

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}