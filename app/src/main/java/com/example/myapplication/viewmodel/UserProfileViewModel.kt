package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.learnmvvm.room.UserDao
import com.example.learnmvvm.room.UserRoomDatabase
import com.example.myapplication.network.User
import com.example.myapplication.repository.UserRepository

class UserProfileViewModel(application: Application) : AndroidViewModel(application) {
    private var userRepository: UserRepository? = null
    var userModelList: LiveData<PagedList<User>>? = null

    init {
        val userRoomDatabase: UserRoomDatabase =
            application.let { UserRoomDatabase.getDatabase(it) }
        val userDao: UserDao = userRoomDatabase.userDao()
        userRepository = UserRepository(userDao)
    }

    fun fetchUserFromNetwork() {
        userRepository?.fetchUserListFromNetwork()
    }

    fun selectUserList() {
        userModelList = userRepository?.selectStudentListViaPagingLibrary()
    }

    fun sameDBCheck() {
        userRepository?.sampleCheck()
    }
}