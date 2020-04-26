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
import com.example.myapplication.network.User

class UserViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
) {

    private val userNameView = itemView.findViewById<TextView>(R.id.tvUserName)
    private val userIdView = itemView.findViewById<TextView>(R.id.tvUserId)
    private val userAvatarView = itemView.findViewById<TextView>(R.id.tvUserAvatar)
    private val userEmailView = itemView.findViewById<TextView>(R.id.tvUserEmail)
    var user: User? = null

    /**
     * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
     * ViewHolder when Item is loaded.
     */
    fun bindTo(user: User?) {
        this.user = user
        userNameView.text = user?.userFirstName
        userIdView.text = user?.userId.toString()
        userAvatarView.text = user?.userAvatar
        userEmailView.text = user?.userEmail
    }
}