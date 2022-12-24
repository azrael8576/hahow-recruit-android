package com.alex.hahow_recruit.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.alex.hahow_recruit.data.AppDatabase
import com.alex.hahow_recruit.data.Data
import com.alex.hahow_recruit.data.Datas
import com.alex.hahow_recruit.utilities.CLASS_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

class HahowClassDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(CLASS_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val dataType = object : TypeToken<Datas>() {}.type
                    val datas: Datas = Gson().fromJson(jsonReader, dataType)
                    val dataList: List<Data> = datas.data

                    val database = AppDatabase.getInstance(applicationContext)
                    database.dataDao().insertAll(dataList)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error class database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "ClassDatabaseWorker"
    }
}