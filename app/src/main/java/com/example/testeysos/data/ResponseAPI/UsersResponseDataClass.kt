package com.example.testeysos.data.ResponseAPI


import com.squareup.moshi.Json

data class UsersResponseDataClass(
    @Json(name = "age")
    val age: Int,
    @Json(name = "city")
    val city: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "photo")
    val photo: String,
    @Json(name = "sexualOrientation")
    val sexualOrientation: String,
    @Json(name = "username")
    val username: String
)