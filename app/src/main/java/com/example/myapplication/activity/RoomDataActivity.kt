package com.example.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.fragment.RoomViaNetworkFragment

class RoomDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_data)

        launchRoomDataFragment()
    }

    private fun launchRoomDataFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.myRoomDataFrameLayout, RoomViaNetworkFragment())
            .commit()
    }
}
