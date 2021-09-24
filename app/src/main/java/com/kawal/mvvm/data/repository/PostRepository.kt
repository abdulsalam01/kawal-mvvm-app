package com.kawal.mvvm.data.repository

import com.kawal.mvvm.data.database.PostDao
import com.kawal.mvvm.data.network.PostApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class PostRepository(private val postDao: PostDao, private val postApi: PostApi) {

    fun getPosts() = postDao.all()

    fun getPostsByUser(userId: Int) = postDao.getByUserId(userId)

    suspend fun refreshPosts(userId: Int) = withContext(Dispatchers.IO) {
        try {
            postDao.insertAll(*postApi.getPostsByUser(userId).await().toTypedArray())
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

}