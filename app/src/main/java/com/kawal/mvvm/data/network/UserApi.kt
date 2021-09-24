package com.kawal.mvvm.data.network

import com.kawal.mvvm.data.model.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/users")
    fun getUsers(): Deferred<List<User>>

    @GET("/users/{userId}")
    fun getUserById(@Path("userId") userId: Int): Deferred<User>
}