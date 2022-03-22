package com.example.daniwebandroidroomtransaction

import androidx.room.*

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(student: Student)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(student: Student)

    @Delete
    abstract suspend fun delete(student: Student)

    @Transaction
    suspend fun insertUpdateDelete(student: Student){
        insert(student)
        update(student)
        delete(student)
    }
}