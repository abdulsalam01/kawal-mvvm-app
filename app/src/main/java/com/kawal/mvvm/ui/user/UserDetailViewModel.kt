package com.kawal.mvvm.ui.user

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kawal.mvvm.base.AsyncViewModel
import com.kawal.mvvm.data.model.Post
import com.kawal.mvvm.data.model.User
import com.kawal.mvvm.data.repository.PostRepository
import com.kawal.mvvm.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserDetailViewModel(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository
) : AsyncViewModel() {

    private val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    private val errorMessage: MutableLiveData<Int> = MutableLiveData()

    lateinit var posts: LiveData<List<Post>>
    lateinit var user: LiveData<User>

    fun loadUser(userId: Int) {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null

        posts = postRepository.getPostsByUser(userId)
        user = userRepository.getUserById(userId)

        launch { userRepository.refreshUser(userId) }
        launch { postRepository.refreshPosts(userId) }
    }
}