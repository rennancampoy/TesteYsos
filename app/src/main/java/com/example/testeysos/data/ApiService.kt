package com.example.testeysos.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Criação do serviço que fará o GET na api

object ApiService {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my.api.mockaroo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service : ApiYsos = initRetrofit().create(ApiYsos::class.java)

}