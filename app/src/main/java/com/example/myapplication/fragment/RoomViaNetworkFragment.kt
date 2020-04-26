package com.example.myapplication.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myapplication.R
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.network.User
import com.example.myapplication.viewmodel.UserProfileViewModel
import kotlinx.android.synthetic.main.fragment_room_via_network.*

/**
 * A simple [Fragment] subclass.
 */
class RoomViaNetworkFragment : Fragment() {

    private lateinit var userProfileViewModel: UserProfileViewModel
    private var userAdapter: UserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room_via_network, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userProfileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        userRecyclerView.layoutManager = linearLayoutManager

        userAdapter = UserAdapter()
        userRecyclerView.adapter = userAdapter

        btnNetwork.setOnClickListener {
            userProfileViewModel.fetchUserFromNetwork()
        }

        btnDatabase.setOnClickListener {
            userProfileViewModel.selectUserList()
            observerPageList()
        }

        btnSample.setOnClickListener {
            userProfileViewModel.sameDBCheck()
        }
    }

    private fun observerPageList() {
        userProfileViewModel.userModelList?.observe(viewLifecycleOwner, Observer { pagedListObject ->

            if (pagedListObject != null) {
                Log.i("-----> ", "PageList Size : ${pagedListObject.size}")
                for (user: User in pagedListObject) {
                    if (user != null) {
                        Log.i("ID :", "" + user.userId)
                        Log.i("Name : ", "" + user.userFirstName)
                        Log.i("Lastname : ", "" + user.userLastName)
                        Log.i("Email : ", "" + user.userEmail)
                        Log.i("Avatar : ", "" + user.userAvatar)
                    }
                }
                userAdapter?.submitList(pagedListObject)
            }
        })
    }

}
