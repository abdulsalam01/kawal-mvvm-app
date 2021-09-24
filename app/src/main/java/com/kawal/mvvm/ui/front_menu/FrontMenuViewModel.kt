package com.kawal.mvvm.ui.front_menu

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.kawal.mvvm.base.AsyncViewModel

class FrontMenuViewModel : AsyncViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val welcomeText = "Selamat datang di KawalApp!"

    init {
        loadingVisibility.value = View.GONE
    }
}