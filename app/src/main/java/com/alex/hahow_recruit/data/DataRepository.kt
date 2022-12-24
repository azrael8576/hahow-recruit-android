package com.alex.hahow_recruit.data

/**
 * Repository module for handling data operations.
 */
class DataRepository private constructor(private val dataDao: DataDao) {

    fun getDatas() = dataDao.getDatas()

    fun getData(category: String) = dataDao.getData(category)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: DataRepository? = null

        fun getInstance(dataDao: DataDao) =
            instance ?: synchronized(this) {
                instance ?: DataRepository(dataDao).also { instance = it }
            }
    }
}
