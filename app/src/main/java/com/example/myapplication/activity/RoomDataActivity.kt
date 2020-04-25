package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.fragment.RoomDataFragment

class RoomDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_data)

        launchRoomDataFragment()
    }

    private fun launchRoomDataFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.myRoomDataFrameLayout, RoomDataFragment())
            .commit()
    }
}
