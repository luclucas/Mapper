package com.lulu.mapper.modules.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.lulu.mapper.R
import com.lulu.mapper.modules.home.ui.Home

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
        btnUpgrade.setOnClickListener{
//            Home().replaceFragment(UpgradeFragment())

        }

        return view


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    fun replaceFragment(fragment:Fragment){
        val newFragment = UpgradeFragment()
        val transaction=requireActivity().supportFragmentManager
            .beginTransaction()
        transaction.replace(R.id.homeLinearLayout,newFragment)
        transaction.commit()
    }

}