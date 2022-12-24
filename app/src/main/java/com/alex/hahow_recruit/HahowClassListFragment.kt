package com.alex.hahow_recruit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alex.hahow_recruit.adapters.HahowClassListAdapter
import com.alex.hahow_recruit.databinding.FragmentHahowClassListBinding
import com.alex.hahow_recruit.utilities.InjectorUtils
import com.alex.hahow_recruit.viewmodels.HahowClassListViewModel

class HahowClassListFragment : Fragment() {

    private val viewModel: HahowClassListViewModel by viewModels {
        InjectorUtils.provideHahowClassListViewModelFactory(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHahowClassListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        Log.e("Alex", "onCreateView")

        val adapter = HahowClassListAdapter()
        binding.hahowClassList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: HahowClassListAdapter) {
        viewModel.datas.observe(viewLifecycleOwner) { datas ->
            adapter.submitList(datas)
        }
    }
}