package com.alex.hahow_recruit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alex.hahow_recruit.HahowClassListFragment
import com.alex.hahow_recruit.data.Data
import com.alex.hahow_recruit.databinding.ListItemCategoryBinding

/**
 * Adapter for the [RecyclerView] in [HahowClassListFragment].
 */
class HahowClassListAdapter(private val onHahowClassListAdapterListener: IOnHahowClassListAdapterListener) : ListAdapter<Data, RecyclerView.ViewHolder>(HahowClassListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HahowClassListViewHolder(
            ListItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        (holder as HahowClassListViewHolder).bind(data, onHahowClassListAdapterListener)
    }

    class HahowClassListViewHolder(
        private val binding: ListItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data, onHahowClassListAdapterListener: IOnHahowClassListAdapterListener) {
            binding.apply {
                binding.hahowClassCategory.text = item.category
                val adapter = HahowClassCoursesAdapter()
                binding.recyclerViewCourses.adapter = adapter
                onHahowClassListAdapterListener?.onSubscribeUi(adapter, item.category)
            }
        }
    }
}

private class HahowClassListDiffCallback : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}

interface IOnHahowClassListAdapterListener {
    fun onSubscribeUi(adapter: HahowClassCoursesAdapter, category: String)
}

