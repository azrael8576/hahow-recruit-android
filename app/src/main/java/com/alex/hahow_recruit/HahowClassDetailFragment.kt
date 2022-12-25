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

    private var binding: FragmentHahowClassDetailBinding? = null
    private val args: HahowClassDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentHahowClassDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            if (args.courses.coverImageUrl.isNotEmpty()) {
                Glide.with(root.context)
                    .load(args.courses.coverImageUrl)
                    .into(imageviewHahowClass)
            }
            hahowClassTittle.text = args.courses.title
            hahowClassAuthor.text = args.courses.name

            setHasOptionsMenu(true)
        }
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}