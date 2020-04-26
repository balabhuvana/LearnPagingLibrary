package com.example.learnmvvm.room

import androidx.paging.DataSource
import androidx.room.*
import com.example.myapplication.network.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudentList(userModelList: List<User>?)

    @Query("SELECT * FROM user_table")
    fun selectStudentListViaPagingLibrary(): DataSource.Factory<Int, User>

}