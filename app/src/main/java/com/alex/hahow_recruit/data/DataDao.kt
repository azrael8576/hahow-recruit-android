package com.alex.hahow_recruit.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Data Access Object for the Data class.
 */
@Dao
interface DataDao {
    @Query("SELECT * FROM datas ORDER BY id")
    fun getDatas(): LiveData<List<Data>>

    @Query("SELECT * FROM datas WHERE category = :category")
    fun getData(category: String): LiveData<Data>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(datas: List<Data>)
}
