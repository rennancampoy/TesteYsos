package com.example.testeysos.views.users

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testeysos.data.ApiService
import com.example.testeysos.data.ResponseAPI.UsersResponseDataClass
import com.example.testeysos.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel: ViewModel() {

    val usersLiveData: MutableLiveData<List<User>> = MutableLiveData()

    val TAG = "MyActivity"


    fun getUsers() {
        //usersLiveData.value = createTestUsers()

        ApiService.service.getUsers().enqueue(object : Callback<List<UsersResponseDataClass>> {
            override fun onResponse(call: Call<List<UsersResponseDataClass>>, response: Response<List<UsersResponseDataClass>>) {
                Log.i(TAG, "ENTROU onResponse")
                if (response.isSuccessful) {
                    Log.i(TAG, "ENTROU")
                    val users: MutableList<User> = mutableListOf()
                    response.body()?.let { body ->
                        for (result in body) {
                            val user = User(
                                username = result.username,
                                age = result.age,
                                city = result.city,
                                gender = result.gender,
                                photo = result.photo,
                                sexualOrientation = result.sexualOrientation
                            )
                            users.add(user)
                        }
                    }
                    usersLiveData.value = users
                }
            }
            override fun onFailure(call: Call<List<UsersResponseDataClass>>, t: Throwable) {
                Log.i(TAG, t.message)
            }
        })
    }

    fun createTestUsers() : List<User> {
        return listOf<User>(
            User("teste1", "Homem", "Bi", "Bauru/SP", "https://i.picsum.photos/id/871/200/200.jpg", 25),
            User("teste2", "Mulher", "Hétero", "Jaú/SP", "https://i.picsum.photos/id/872/200/200.jpg", 40),
            User("teste3", "Mulher", "Pan", "Bauru/SP", "https://i.picsum.photos/id/873/200/200.jpg", 28),
            User("teste4", "Homem", "Homo", "Pederneiras/SP", "https://i.picsum.photos/id/874/200/200.jpg", 30)

        )
    }
}