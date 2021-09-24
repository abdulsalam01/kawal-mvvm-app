package com.kawal.mvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@field:PrimaryKey val id: Int, val name: String, val username: String, val email: String, val phone: String, val website: String)