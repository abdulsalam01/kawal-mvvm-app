package com.kawal.mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kawal.mvvm.data.model.Post
import com.kawal.mvvm.data.model.User

@Database(entities = [Post::class, User::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun postDao(): PostDao

    abstract fun userDao(): UserDao

}