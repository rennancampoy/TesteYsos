package com.example.testeysos.views.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testeysos.data.model.User

class UsersViewModel: ViewModel() {

    val usersLiveData: MutableLiveData<List<User>> = MutableLiveData()

    fun getUsers() {
        usersLiveData.value = createFakeUsers()
    }

    fun createFakeUsers() : List<User> {
        return listOf<User>(
            User("teste1", "Homem", "Bi", "Bauru/SP", "https://i.picsum.photos/id/871/200/200.jpg", 25),
            User("teste2", "Mulher", "Hétero", "Jaú/SP", "https://i.picsum.photos/id/872/200/200.jpg", 40),
            User("teste3", "Mulher", "Pan", "Bauru/SP", "https://i.picsum.photos/id/873/200/200.jpg", 28),
            User("teste4", "Homem", "Homo", "Pederneiras/SP", "https://i.picsum.photos/id/874/200/200.jpg", 30)

        )
    }
}