package com.example.daniwebandroidroomtransaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.withTransaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, "my-database"
        ).build()

        lifecycleScope.launch(Dispatchers.IO) {
            val student = Student(
                id = 1,
                name = "John",
                age = 6
            )
            //db.studentDao().insertUpdateDelete(student)

            val studentDao = db.studentDao()

            db.withTransaction {
                studentDao.insert(student)
                studentDao.update(student)
                studentDao.delete(student)
            }
        }
    }
}