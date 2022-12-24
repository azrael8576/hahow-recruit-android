package com.alex.hahow_recruit.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.alex.hahow_recruit.data.AppDatabase
import com.alex.hahow_recruit.data.DataRepository
import com.alex.hahow_recruit.viewmodels.HahowClassListViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    private fun getDatasRepository(context: Context): DataRepository {
        return DataRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).dataDao()
        )
    }

    fun provideHahowClassListViewModelFactory(fragment: Fragment): HahowClassListViewModelFactory {
        return HahowClassListViewModelFactory(getDatasRepository(fragment.requireContext()), fragment)
    }

}
