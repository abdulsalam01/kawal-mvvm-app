package com.kawal.mvvm.ui.front_menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kawal.mvvm.R
import com.kawal.mvvm.databinding.FrontMenuFragmentBinding
import com.kawal.mvvm.ui.user.UserListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FrontMenuFragment : Fragment() {

    companion object {
        fun newInstance() = FrontMenuFragment()
    }

    private lateinit var binding: FrontMenuFragmentBinding
    private val viewModel: FrontMenuViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.front_menu_fragment, container, false)
        this.binding.viewModel = this.viewModel
        this.binding.lifecycleOwner = this

        return this.binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}