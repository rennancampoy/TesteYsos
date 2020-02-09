package com.example.testeysos.data

import com.example.testeysos.data.ResponseAPI.UsersResponseDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiYsos {

    @GET("mobiletest.json")
    fun getUsers(
        @Header("X-API-Key") key: String = "82333f10"
    ): Call<List<UsersResponseDataClass>>
}