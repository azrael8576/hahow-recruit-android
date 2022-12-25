package com.alex.hahow_recruit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alex.hahow_recruit.data.Courses
import com.alex.hahow_recruit.databinding.ListFirstItemHahowClassBinding
import com.alex.hahow_recruit.databinding.ListItemHahowClassBinding
import com.alex.hahow_recruit.utilities.HAHOW_CLASS_COURSES_PHONE_MAX_COUNT
import com.bumptech.glide.Glide

enum class ItemViewType {
    FIRST_ITEM, OTHER_ITEM
}

/**
 * Adapter for the [RecyclerView] in [HahowClassListAdapter].
 */
class HahowClassCoursesAdapter : ListAdapter<Courses, RecyclerView.ViewHolder>(HahowClassCoursesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemViewType.FIRST_ITEM.ordinal -> {
                HahowClassCoursesFristItemViewHolder(
                    ListFirstItemHahowClassBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            ItemViewType.OTHER_ITEM.ordinal -> {
                HahowClassCoursesViewHolder(
                    ListItemHahowClassBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                HahowClassCoursesViewHolder(
                    ListItemHahowClassBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val courses = getItem(position)
        when (holder) {
            is HahowClassCoursesFristItemViewHolder -> {
                holder.bind(courses)
            }
            is HahowClassCoursesViewHolder -> {
                holder.bind(courses)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ItemViewType.FIRST_ITEM.ordinal
            else -> ItemViewType.OTHER_ITEM.ordinal
        }
    }

    override fun getItemCount(): Int {
        return if (super.getItemCount() > HAHOW_CLASS_COURSES_PHONE_MAX_COUNT) {
            HAHOW_CLASS_COURSES_PHONE_MAX_COUNT
        } else {
            super.getItemCount()
        }
    }

    class HahowClassCoursesFristItemViewHolder(
        private val binding: ListFirstItemHahowClassBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Courses) {
            binding.apply {
                if (item.coverImageUrl.isNotEmpty()) {
                    Glide.with(binding.root.context)
                        .load(item.coverImageUrl)
                        .into(binding.imageviewHahowClass)
                }
                binding.hahowClassTittle.text = item.title
                binding.hahowClassAuthor.text = item.name
            }
        }
    }

    class HahowClassCoursesViewHolder(
        private val binding: ListItemHahowClassBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Courses) {
            binding.apply {
                if (item.coverImageUrl.isNotEmpty()) {
                    Glide.with(binding.root.context)
                        .load(item.coverImageUrl)
                        .into(binding.imageviewHahowClass)
                }
                binding.hahowClassTittle.text = item.title
                binding.hahowClassAuthor.text = item.name
            }
        }
    }
}

private class HahowClassCoursesDiffCallback : DiffUtil.ItemCallback<Courses>() {

    override fun areItemsTheSame(oldItem: Courses, newItem: Courses): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Courses, newItem: Courses): Boolean {
        return oldItem == newItem
    }
}
