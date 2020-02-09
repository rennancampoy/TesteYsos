package com.example.testeysos.views.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeysos.R
import com.example.testeysos.views.userDetails.UserDetailsActivity
import kotlinx.android.synthetic.main.list_user_layout.*

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Configura o layout XML da lista de usuários para responder à essa Activity
        setContentView(R.layout.list_user_layout)

        //Nome e configuração da Toolbar
        toolbarMain.title = getString(R.string.toolbarNameListUsers)
        setSupportActionBar(toolbarMain)

        //Obtém o ViewModel dos usuários
        val viewModel: UsersViewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        //Faz a ViewModel observar os dados do objeto LiveData
        viewModel.usersLiveData.observe(this, Observer {
            it?.let { users -> //Garante que a lista possui valores
                with(RecyclerUsers) {
                    //Usando o GridLayoutManager que será responsável por configurar o layout com 2 registros (spanCount) por linha
                    layoutManager = GridLayoutManager(this@UsersActivity, 2, RecyclerView.VERTICAL, false)

                    //O UsersAdapter recebe uma lista de usuários, que neste caso será a lista users fornecida pelo LiveData na ViewModel
                    adapter = UsersAdapter(users) { user ->
                        val intent = UserDetailsActivity.getStartIntent(this@UsersActivity, user)
                        //Inicia a activity declarada na
                        this@UsersActivity.startActivity(intent)
                    }
                }
            }
        })

        //Atualiza a LiveData com os usuários da API, o que acarretará na atualização da view e do layout
        viewModel.getUsers()

    }
}
