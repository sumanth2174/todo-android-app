package com.example.todo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "Task_table")
data class Task(
    @PrimaryKey
    val taskId: Long,
    val nextAlarmTime: Timestamp,
    val subTasks: List<Task>,
    val description: String,
    val status: Status,
    val priority: Priority,
    val parentTaskId: Long?
)


enum class Status {
    OPEN, IN_PROGRESS, CLOSED
}

enum class Priority {
    LOW, MEDIUM, HIGH
}