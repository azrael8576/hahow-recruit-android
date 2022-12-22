package com.alex.hahow_recruit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HahowClassListFragment : Fragment() {

    companion object {
        fun newInstance() = HahowClassListFragment()
    }

    private lateinit var viewModel: HahowClassListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hahow_class_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HahowClassListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}