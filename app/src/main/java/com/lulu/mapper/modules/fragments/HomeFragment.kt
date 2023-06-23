package com.lulu.mapper.modules.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.lulu.mapper.R
import com.lulu.mapper.modules.calculadora_sisu.ui.CalculadoraSisuFragment

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val btnUpgrade: AppCompatButton = view.findViewById(R.id.btnUpgrade)
        val cardCalculadora: LinearLayout = view.findViewById(R.id.linearCalculadoraSisu)

        btnUpgrade.setOnClickListener{
            replaceFragment(UpgradeFragment())
        }

        cardCalculadora.setOnClickListener{
            replaceFragment(CalculadoraSisuFragment())
        }

        return view


    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun replaceFragment(fragment:Fragment){
        val transaction=requireActivity().supportFragmentManager
            .beginTransaction()
        transaction.replace(R.id.homeLinearLayout, fragment)
        transaction.commit()
    }

}