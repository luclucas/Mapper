package com.lulu.mapper.modules.calculadora_sisu.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.lulu.mapper.R
import com.lulu.mapper.modules.selecao_curso.SelecaoCurso
import com.lulu.mapper.modules.ufs.ui.UfFragment

class CalculadoraSisuFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculadora_sisu, container, false)

        val linearEstado: LinearLayout = view.findViewById(R.id.linearEstado)
        val linearCurso: LinearLayout = view.findViewById(R.id.linearCurso)

        linearEstado.setOnClickListener{
            replaceFragment(UfFragment())
        }

        linearCurso.setOnClickListener {
            replaceFragment(SelecaoCurso())
        }

        return view
    }


    private fun replaceFragment(fragment:Fragment){
        val transaction=requireActivity().supportFragmentManager
            .beginTransaction()
        transaction.replace(R.id.homeLinearLayout, fragment)
        transaction.commit()
    }

}