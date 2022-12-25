package com.alex.hahow_recruit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.alex.hahow_recruit.databinding.FragmentHahowClassDetailBinding
import com.bumptech.glide.Glide

class HahowClassDetailFragment : Fragment() {

    private val args: HahowClassDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHahowClassDetailBinding.inflate(inflater, container, false)
        context ?: return binding.root

        initView(binding)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun initView(binding: FragmentHahowClassDetailBinding) {
        if (args.courses.coverImageUrl.isNotEmpty()) {
            Glide.with(binding.root.context)
                .load(args.courses.coverImageUrl)
                .into(binding.imageviewHahowClass)
        }
        binding.hahowClassTittle.text = args.courses.title
        binding.hahowClassAuthor.text = args.courses.name
    }

}