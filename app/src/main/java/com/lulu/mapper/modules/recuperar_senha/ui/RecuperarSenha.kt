package com.lulu.mapper.modules.recuperar_senha.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.lulu.mapper.R

class RecuperarSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_senha)

        val backIcon: ImageView = findViewById(R.id.imageArrowleft)
        backIcon.setOnClickListener{
            finish()
        }

    }


}