package com.lulu.mapper.modules.login.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lulu.mapper.R
import com.lulu.mapper.modules.criar_conta.ui.CriarConta
import com.lulu.mapper.modules.home.ui.Home
import com.lulu.mapper.modules.recuperar_senha.ui.RecuperarSenha

class LoginScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val txtEsqueciSenha: TextView = findViewById(R.id.txtEsqueciSenha)
        val txtCriarConta: TextView = findViewById(R.id.txtCriarConta)
        val btnLogin: Button = findViewById(R.id.btnFazerLogin)

        txtEsqueciSenha.setOnClickListener{
            val intent = Intent(this@LoginScreen, RecuperarSenha::class.java)
            startActivity(intent)
        }

        txtCriarConta.setOnClickListener{
            startActivity(CriarConta().getIntent(this@LoginScreen))
        }

        btnLogin.setOnClickListener{
            startActivity(Home().getIntent(this@LoginScreen))
        }

    }
}