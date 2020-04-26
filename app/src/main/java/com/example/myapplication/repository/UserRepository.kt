package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.learnmvvm.network.RetrofitService
import com.example.learnmvvm.network.UserListModelRoot
import com.example.learnmvvm.room.UserDao
import com.example.myapplication.network.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository(private var userDao: UserDao) {

    private var retrofitService = RetrofitService()

    fun fetchUserListFromNetwork() {
        val callUserModelList = retrofitService.userApi.getUserList()
        callUserModelList.enqueue(object : Callback<UserListModelRoot> {
            override fun onFailure(call: Call<UserListModelRoot>, t: Throwable) {
                Log.i("---> ", " onFailure " + t.localizedMessage)
            }

            override fun onResponse(
                call: Call<UserListModelRoot>,
                response: Response<UserListModelRoot>
            ) {
                var userListModelRoot: UserListModelRoot? = response.body()
                Log.i("---> ", "" + userListModelRoot?.userModelList?.size)
                insertUserData(userListModelRoot?.userModelList)
            }
        })
    }

    fun insertUserData(userModelList: List<User>?) {
        GlobalScope.launch {
            userDao.insertStudentList(userModelList)
        }
    }

    fun selectStudentListViaPagingLibrary(): LiveData<PagedList<User>> {
        return userDao.selectStudentListViaPagingLibrary()
            .toLiveData(Config(pageSize = 10, enablePlaceholders = true, maxSize = 200))
    }

    fun sampleCheck() {
        var listUser = ArrayList<User>()

        val user1 = User()
        user1.userFirstName = "Arun"
        user1.userLastName = "Kumar"
        user1.userEmail = "arun@gmail.com"
        user1.userAvatar = "https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg"

        val user2 = User()
        user2.userFirstName = "Anand"
        user2.userLastName = "Kumar"
        user2.userEmail = "anand@gmail.com"
        user2.userAvatar = "https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg"

        listUser.add(user1)
        listUser.add(user2)

        insertUserData(listUser)

    }
}