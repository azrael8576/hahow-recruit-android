package com.alex.hahow_recruit.viewmodels

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.alex.hahow_recruit.data.DataRepository

/**
 * Factory for creating a [HahowClassListViewModel] with a constructor that takes a [DataRepository].
 */
class HahowClassListViewModelFactory(
    private val repository: DataRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return HahowClassListViewModel(repository, handle) as T
    }
}
