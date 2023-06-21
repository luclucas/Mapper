package com.lulu.mapper.modules.splashscreen.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.lulu.mapper.R
import com.lulu.mapper.modules.login.ui.LoginScreen
import java.util.Timer
import kotlin.concurrent.schedule

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val timer = Timer()

        timer.schedule(2000) {
            val intent = Intent(this@SplashScreen, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}