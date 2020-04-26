package com.example.myapplication.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.network.User

class UserAdapter : PagedListAdapter<User, UserViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<User>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(
                oldConcert: User,
                newConcert: User
            ) = oldConcert.userId == newConcert.userId

            override fun areContentsTheSame(
                oldConcert: User,
                newConcert: User
            ) = oldConcert == newConcert
        }
    }
}