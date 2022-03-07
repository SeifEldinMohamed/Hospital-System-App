package com.seif.hospitalsystem.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Case(
    val id: Int,
    val patientName: String,
    val patientAge: Int,
    val phoneNumber: String,
    val date: String,
    val caseStatus: Status,
    val caseDescription: String,
    val assignedDoctor: String
):Parcelable
