package com.example.testeysos.data

import com.example.testeysos.data.responseAPI.UsersResponseDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

//Interface usada para configurar o endpoint e header da requisição, retornando a lista de usuários

interface ApiYsos {
    @GET("mobiletest.json")
    fun getUsers(
        @Header("X-API-Key") key: String = "82333f10"
    ): Call<List<UsersResponseDataClass>>
}