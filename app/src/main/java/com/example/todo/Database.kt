package com.example.todo

import android.content.Context
import androidx.room.Database as db
import androidx.room.Room
import androidx.room.RoomDatabase

@db(entities = [Task::class], version = 1)
abstract class Database private constructor() : RoomDatabase() {
    abstract fun getTaskDAO(): TaskDAO

    companion object {
        private var db: Database? = null

        fun getInstance(applicationContext: Context): Database {
            return db ?: run {
                synchronized(this) {
                    Room.databaseBuilder(
                        applicationContext,
                        Database::class.java,
                        "Task_local_database"
                    ).fallbackToDestructiveMigration().build()
                }
            }
        }
    }
}