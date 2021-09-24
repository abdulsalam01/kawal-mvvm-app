package com.kawal.mvvm.data.network

import com.kawal.mvvm.data.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("/posts")
    fun getPosts(): Deferred<List<Post>>

    @GET("/users/{userId}/posts")
    fun getPostsByUser(@Path("userId") userId: Int): Deferred<List<Post>>

}