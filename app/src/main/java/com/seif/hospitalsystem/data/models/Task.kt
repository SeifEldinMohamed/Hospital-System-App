package com.seif.hospitalsystem.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id:Int,
    val name:String,
    val status: Status,
    val note: String,
    val date:String,
    val todoList: List<String>
): Parcelable
