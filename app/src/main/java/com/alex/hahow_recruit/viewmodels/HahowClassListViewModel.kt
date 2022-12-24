package com.alex.hahow_recruit.viewmodels

import androidx.lifecycle.*
import com.alex.hahow_recruit.data.Data
import com.alex.hahow_recruit.data.DataRepository

class HahowClassListViewModel internal constructor(
    dataRepository: DataRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val datas: LiveData<List<Data>> = dataRepository.getDatas()
}