package com.example.myapplication.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.room.Student

class StudentAdapter : PagedListAdapter<Student, StudentViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder(parent)

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Student>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(
                oldConcert: Student,
                newConcert: Student
            ) = oldConcert.studentRollNo == newConcert.studentRollNo

            override fun areContentsTheSame(
                oldConcert: Student,
                newConcert: Student
            ) = oldConcert == newConcert
        }
    }
}