package com.kawal.mvvm.ui.input_data

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kawal.mvvm.R

class InputDataFragment : Fragment() {

    companion object {
        fun newInstance() = InputDataFragment()
    }

    private lateinit var viewModel: InputDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InputDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}