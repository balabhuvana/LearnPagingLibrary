package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.myapplication.repository.StudentRepository
import com.example.myapplication.room.Student
import com.example.myapplication.room.StudentDao
import com.example.myapplication.room.StudentRoomDatabase

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private var studentDao: StudentDao
    private var studentRepository: StudentRepository
    var concreteList: LiveData<PagedList<Student>>? = null
    private val studentList: ArrayList<Student> = arrayListOf()

    init {
        val userRoomDatabase: StudentRoomDatabase =
            application.let { StudentRoomDatabase.getDatabase(it) }
        studentDao = userRoomDatabase.studentDao()
        studentRepository = StudentRepository(studentDao)
    }

    fun insertStudentList() {
        insertPartOne()
        insertPartTwo()
    }

    private fun insertPartOne() {
        val student1 = Student()
        student1.studentName = "Arun V 1"
        student1.studentAge = 34 + 1
        student1.studentPlace = "Salem $1"
        studentList.add(student1)

        val student2 = Student()
        student2.studentName = "Arun V 2"
        student2.studentAge = 34 + 2
        student2.studentPlace = "Salem $2"
        studentList.add(student2)

        val student3 = Student()
        student3.studentName = "Arun V 3"
        student3.studentAge = 34 + 3
        student3.studentPlace = "Salem $3"
        studentList.add(student3)

        val student4 = Student()
        student4.studentName = "Arun V 4"
        student4.studentAge = 34 + 4
        student4.studentPlace = "Salem $4"
        studentList.add(student4)

        val student5 = Student()
        student5.studentName = "Arun V 5"
        student5.studentAge = 34 + 5
        student5.studentPlace = "Salem $5"
        studentList.add(student5)

        val student6 = Student()
        student6.studentName = "Arun V 6"
        student6.studentAge = 34 + 6
        student6.studentPlace = "Salem $6"
        studentList.add(student6)

        val student7 = Student()
        student7.studentName = "Arun V 7"
        student7.studentAge = 34 + 7
        student7.studentPlace = "Salem $7"
        studentList.add(student7)

        val student8 = Student()
        student8.studentName = "Arun V 8"
        student8.studentAge = 34 + 8
        student8.studentPlace = "Salem $8"
        studentList.add(student8)

        val student9 = Student()
        student9.studentName = "Arun V 9"
        student9.studentAge = 34 + 9
        student9.studentPlace = "Salem $9"
        studentList.add(student9)

        val student10 = Student()
        student10.studentName = "Arun V 10"
        student10.studentAge = 34 + 10
        student10.studentPlace = "Salem $10"
        studentList.add(student10)

        studentRepository.insertStudentRecordsList(studentList)
    }

    private fun insertPartTwo() {
        val student1 = Student()
        student1.studentName = "Arun V 1"
        student1.studentAge = 34 + 1
        student1.studentPlace = "Salem $1"
        studentList.add(student1)

        val student2 = Student()
        student2.studentName = "Arun V 2"
        student2.studentAge = 34 + 2
        student2.studentPlace = "Salem $2"
        studentList.add(student2)

        val student3 = Student()
        student3.studentName = "Arun V 3"
        student3.studentAge = 34 + 3
        student3.studentPlace = "Salem $3"
        studentList.add(student3)

        val student4 = Student()
        student4.studentName = "Arun V 4"
        student4.studentAge = 34 + 4
        student4.studentPlace = "Salem $4"
        studentList.add(student4)

        val student5 = Student()
        student5.studentName = "Arun V 5"
        student5.studentAge = 34 + 5
        student5.studentPlace = "Salem $5"
        studentList.add(student5)

        val student6 = Student()
        student6.studentName = "Arun V 6"
        student6.studentAge = 34 + 6
        student6.studentPlace = "Salem $6"
        studentList.add(student6)

        val student7 = Student()
        student7.studentName = "Arun V 7"
        student7.studentAge = 34 + 7
        student7.studentPlace = "Salem $7"
        studentList.add(student7)

        val student8 = Student()
        student8.studentName = "Arun V 8"
        student8.studentAge = 34 + 8
        student8.studentPlace = "Salem $8"
        studentList.add(student8)

        val student9 = Student()
        student9.studentName = "Arun V 9"
        student9.studentAge = 34 + 9
        student9.studentPlace = "Salem $9"
        studentList.add(student9)

        val student10 = Student()
        student10.studentName = "Arun V 10"
        student10.studentAge = 34 + 10
        student10.studentPlace = "Salem $10"
        studentList.add(student10)

        studentRepository.insertStudentRecordsList(studentList)
    }

    fun selectConcreteList() {
        concreteList = studentRepository.selectStudentListViaPagingLibrary()
    }

    fun updateRecord(student: Student){
        studentRepository.updateRecord(student)
    }

    fun deleteStudentRecord(student: Student) {
        studentRepository.deleteRecord(student)
    }

}