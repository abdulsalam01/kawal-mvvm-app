package com.kawal.mvvm.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kawal.mvvm.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun all(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id=:userId")
    fun getById(userId: Int): LiveData<User>

    @get:Query("SELECT count(*) FROM user")
    val count: Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg users: User)

}