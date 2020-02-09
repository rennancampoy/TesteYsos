package com.example.testeysos.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class UserParcelable (
    val username: String,
    val gender: String,
    val sexualOrientation: String,
    val city: String,
    val photo: String,
    val age: Int
): Parcelable