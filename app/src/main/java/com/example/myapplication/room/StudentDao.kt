package com.example.myapplication.room

import androidx.paging.DataSource
import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudentList(studentList: List<Student>)

    @Delete
    fun deleteSpecificRecord(student: Student)

    @Query("SELECT * FROM student_table")
    fun selectStudentListViaPagingLibrary(): DataSource.Factory<Int, Student>

    @Update
    fun updateStudentRecord(student: Student)

}