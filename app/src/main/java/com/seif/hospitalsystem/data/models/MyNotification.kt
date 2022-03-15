package com.seif.hospitalsystem.data.models

data class MyNotification(
    val id:Int,
    val senderName:String,
    val notificationBody:String,
    val time:String,
    val senderImage:Int
)
