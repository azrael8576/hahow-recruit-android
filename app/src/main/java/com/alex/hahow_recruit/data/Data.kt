package com.alex.hahow_recruit.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize

@TypeConverters(Converters::class)
data class Datas(
    val data: List<Data>
)

@Entity(tableName = "datas")
@TypeConverters(Converters::class)
data class Data(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val category: String,
    val courses: List<Courses>
)

@Parcelize
data class Courses(
    val title: String,
    val coverImageUrl: String = "",
    val name: String,
    val category: String
): Parcelable