/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.room.Student

class StudentViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
) {

    private val nameView = itemView.findViewById<TextView>(R.id.tvStudentName)
    private val rollNoView = itemView.findViewById<TextView>(R.id.tvStudentRollNo)
    private val ageView = itemView.findViewById<TextView>(R.id.tvStudentAge)
    private val placeView = itemView.findViewById<TextView>(R.id.tvStudentPlace)
    var student: Student? = null

    /**
     * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
     * ViewHolder when Item is loaded.
     */
    fun bindTo(student: Student?) {
        this.student = student
        nameView.text = student?.studentName
        rollNoView.text = student?.studentRollNo.toString()
        ageView.text = student?.studentAge.toString()
        placeView.text = student?.studentPlace
    }
}