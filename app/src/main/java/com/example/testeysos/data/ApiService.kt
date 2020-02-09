package com.example.testeysos.data

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
    val TAG = "ApiService"
    private fun initRetrofit(): Retrofit {
        Log.i(TAG, "initRetrofit")
        return Retrofit.Builder()
            .baseUrl("https://my.api.mockaroo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service : ApiYsos = initRetrofit().create(ApiYsos::class.java)

}