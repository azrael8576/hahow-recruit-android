package com.alex.hahow_recruit.viewmodels

import androidx.lifecycle.*
import com.alex.hahow_recruit.data.Data
import com.alex.hahow_recruit.data.DataRepository

class HahowClassListViewModel internal constructor(
    dataRepository: DataRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _DataRepository = dataRepository
    val datas: LiveData<List<Data>> = _DataRepository.getDatas()

    fun getData(category: String): LiveData<Data> {
        return _DataRepository.getData(category)
    }
}