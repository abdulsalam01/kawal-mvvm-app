package com.kawal.mvvm.ui.user

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kawal.mvvm.base.AsyncViewModel
import com.kawal.mvvm.data.model.User
import com.kawal.mvvm.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserListViewModel(
    private val userRepository: UserRepository
) :
    AsyncViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadUsers() }

    val users: LiveData<List<User>> = userRepository.getUsers()

    init {
        loadingVisibility.value = View.GONE
        loadUsers()
    }

    fun loadUsers() {
        launch {
            if (userRepository.getCachedCount() == 0) {
                loadingVisibility.value = View.VISIBLE
            }

            userRepository.refreshUsers()

            loadingVisibility.value = View.GONE
        }
    }
}