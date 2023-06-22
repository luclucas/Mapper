package com.lulu.mapper.modules.home.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.lulu.mapper.R
import com.lulu.mapper.databinding.ActivityHomeBinding
import com.lulu.mapper.modules.fragments.HomeFragment
import com.lulu.mapper.modules.fragments.UpgradeFragment

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment())
//                R.id.nav_messages -> replaceFragment(HomeFragment())
//                R.id.nav_icone -> replaceFragment(HomeFragment())
//                R.id.nav_statistics -> replaceFragment(HomeFragment())
//                R.id.nav_profile -> replaceFragment(HomeFragment())

                else ->{}
            }
            true
        }



    }

    fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.homeLinearLayout, fragment)
        fragmentTransaction.commit()
    }
    fun getIntent(context: Context): Intent {
        return Intent(context, Home::class.java)
    }
}