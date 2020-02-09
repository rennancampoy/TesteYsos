package com.example.testeysos.views.users

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testeysos.data.ApiService
import com.example.testeysos.data.responseAPI.UsersResponseDataClass
import com.example.testeysos.data.model.UserParcelable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel: ViewModel() {

    val usersLiveData: MutableLiveData<List<UserParcelable>> = MutableLiveData()

    val TAG = "ERRO_REQUEST"

    fun getUsers() {
        //usersLiveData.value = createTestUsers()

        ApiService.service.getUsers().enqueue(object : Callback<List<UsersResponseDataClass>> {
            override fun onResponse(call: Call<List<UsersResponseDataClass>>, response: Response<List<UsersResponseDataClass>>) {
                if (response.isSuccessful) {
                    val users: MutableList<UserParcelable> = mutableListOf()
                    response.body()?.let { body ->
                        for (result in body) {
                            val user = UserParcelable(
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

    fun createTestUsers() : List<UserParcelable> {
        return listOf<UserParcelable>(
            UserParcelable("teste1", "Homem", "Bi", "Bauru/SP", "https://i.picsum.photos/id/871/200/200.jpg", 25),
            UserParcelable("teste2", "Mulher", "Hétero", "Jaú/SP", "https://i.picsum.photos/id/872/200/200.jpg", 40),
            UserParcelable("teste3", "Mulher", "Pan", "Bauru/SP", "https://i.picsum.photos/id/873/200/200.jpg", 28),
            UserParcelable("teste4", "Homem", "Homo", "Pederneiras/SP", "https://i.picsum.photos/id/874/200/200.jpg", 30)

        )
    }
}