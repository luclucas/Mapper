package com.lulu.mapper.modules.criar_conta.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lulu.mapper.R

class CriarConta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)
    }

    fun getIntent(context: Context): Intent{
        return Intent(context, CriarConta::class.java)
    }
}