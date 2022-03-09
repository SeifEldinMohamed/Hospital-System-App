package com.seif.hospitalsystem.data.models

data class Report(
    val id:Int,
    val name:String,
    val status: Status,
    val description: String,
    val image: Int,
    val date:String
)
