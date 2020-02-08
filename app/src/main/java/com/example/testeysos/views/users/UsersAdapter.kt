package com.example.testeysos.views.users

import android.text.TextUtils.concat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testeysos.R
import com.example.testeysos.data.model.User
import kotlinx.android.synthetic.main.item_user_layout.view.*

// Neste Adapter será usado o ViewHolder Pattern para guardar a view de usuários
// A vantagem deste padrão é ter um objeto onde estão referenciadas views, para evitar o uso repetido do método findViewById()
// O método onBindViewHolder é usado para determinar qual será o usuário com base na posição(position) da lista

class UsersAdapter(
    //Lista de usuários recebida do ViewModel
    private val users: List<User>
) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    //Transformando o layout XML do usuário em uma View
    override fun onCreateViewHolder(parent: ViewGroup, view: Int): UsersViewHolder {
        val userView = LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
        return UsersViewHolder(userView)
    }

    override fun getItemCount() = users.count()

    override fun onBindViewHolder(viewHolder: UsersViewHolder, position: Int) {
        viewHolder.bindView(users[position])
    }

    class UsersViewHolder(userView: View) : RecyclerView.ViewHolder(userView) {

        private val username = userView.userUsername
        private val photo = userView.userPhoto
        private val genderOrientationAge = userView.userGenderOrientationAge
        private val city = userView.userCity


        fun bindView(user: User) {
            username.text = user.username
            genderOrientationAge.text = concat(user.gender," ", user.sexualOrientation, ", ", user.age.toString())
            //Usa o Glide para carregar uma URL na propriedade photo da view
            Glide.with(itemView).load(user.photo).into(photo)
            city.text = user.city
        }
    }
}