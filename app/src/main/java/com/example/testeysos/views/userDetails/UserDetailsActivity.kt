package com.example.testeysos.views.userDetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.testeysos.R
import com.example.testeysos.data.model.UserParcelable
import kotlinx.android.synthetic.main.details_user_layout.*

class UserDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_user_layout)

        val user = intent.getParcelableExtra<UserParcelable>("EXTRA_USER")

        //valorando os textos e foto da tela de detalhes
        userDetailAge.text = user.age.toString()
        userDetailCity.text = user.city.toString()
        userDetailGender.text = user.gender
        Glide.with(applicationContext).load(user.photo).into(userDetailPhoto)
        userDetailSexualOrientation.text = user.sexualOrientation
        userDetailUsername.text = user.username

        
        //Configuração da toolbar da tela de detalhes
        setSupportActionBar(toolbarMain)
        if (toolbarMain != null) {
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar()?.setDisplayShowHomeEnabled(true);
            getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        }
    }

    //Criação do getStartIntent para disponibilizar o objeto para todas as activities
    companion object {
        fun getStartIntent(context: Context, user: UserParcelable): Intent {
            return Intent(context, UserDetailsActivity::class.java).apply {
                putExtra("EXTRA_USER", user)
            }
        }
    }
}
