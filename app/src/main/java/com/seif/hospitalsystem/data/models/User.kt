package com.seif.hospitalsystem.data.models

data class User(
    val id: Int,
    val userStatus: UserStatus,
    val firstName:String,
    val lastName:String,
    val image:Int,
    val gender:Gender,
    val specialist: Specialist,
    val status : MaritalStatus,
    val dateOfBirth: String,
    val phoneNumber:String,
    val email:String,
    val address: String,
    val password:String
)
