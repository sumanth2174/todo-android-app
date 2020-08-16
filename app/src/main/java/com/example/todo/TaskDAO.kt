package com.example.todo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDAO {

    @Insert
    fun insertTask(task: Task)

    @Query("SELECT * FROM Task_table")
    fun getAllTask(): LiveData<List<Task>>

}