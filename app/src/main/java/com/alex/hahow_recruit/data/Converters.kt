package com.alex.hahow_recruit.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Type converters to allow Room to reference complex data types.
 */
class Converters {
    @TypeConverter fun stringToObject(jsonString: String): List<Courses> {
        val listType = object : TypeToken<List<Courses>>() {

        }.type
        return Gson().fromJson(jsonString, listType)
    }

    @TypeConverter
    fun objectToString(list: List<Courses>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
