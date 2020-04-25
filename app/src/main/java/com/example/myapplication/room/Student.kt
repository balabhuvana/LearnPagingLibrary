package com.example.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "roll_no")
    var studentRollNo: Int = 0,

    @ColumnInfo(name = "student_name")
    var studentName: String = "",

    @ColumnInfo(name = "student_age")
    var studentAge: Int = 0,

    @ColumnInfo(name = "student_place")
    var studentPlace: String = ""
)
