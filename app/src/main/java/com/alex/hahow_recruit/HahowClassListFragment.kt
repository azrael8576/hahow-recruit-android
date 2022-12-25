package com.alex.hahow_recruit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alex.hahow_recruit.adapters.HahowClassCoursesAdapter
import com.alex.hahow_recruit.adapters.HahowClassListAdapter
import com.alex.hahow_recruit.adapters.IOnHahowClassListAdapterListener
import com.alex.hahow_recruit.databinding.FragmentHahowClassListBinding
import com.alex.hahow_recruit.utilities.InjectorUtils
import com.alex.hahow_recruit.viewmodels.HahowClassListViewModel

class HahowClassListFragment : Fragment(), IOnHahowClassListAdapterListener {

    private var binding: FragmentHahowClassListBinding? = null
    private val viewModel: HahowClassListViewModel by viewModels {
        InjectorUtils.provideHahowClassListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentHahowClassListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            val adapter = HahowClassListAdapter(this@HahowClassListFragment)
            hahowClassList.adapter = adapter
            subscribeUi(adapter)

            setHasOptionsMenu(true)
        }
    }

    private fun subscribeUi(adapter: HahowClassListAdapter) {
        viewModel.datas.observe(viewLifecycleOwner) { datas ->
            adapter.submitList(datas)
        }
    }

    override fun onSubscribeUi(adapter: HahowClassCoursesAdapter, category: String) {
        viewModel.getData(category).observe(viewLifecycleOwner) { data ->
            adapter.submitList(data.courses)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}