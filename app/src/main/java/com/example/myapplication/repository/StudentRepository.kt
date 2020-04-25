package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.myapplication.room.Student
import com.example.myapplication.room.StudentDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StudentRepository(private var studentDao: StudentDao) {


    fun insertStudentRecordsList(studentList: List<Student>) {
        GlobalScope.launch {
            studentDao.insertStudentList(studentList)
        }
    }

    fun selectStudentListViaPagingLibrary(): LiveData<PagedList<Student>> {
        return studentDao.selectStudentListViaPagingLibrary()
            .toLiveData(Config(pageSize = 10, enablePlaceholders = true, maxSize = 200))
    }

    fun deleteRecord(student: Student) {
        GlobalScope.launch {
            studentDao.deleteSpecificRecord(student)
        }
    }

}