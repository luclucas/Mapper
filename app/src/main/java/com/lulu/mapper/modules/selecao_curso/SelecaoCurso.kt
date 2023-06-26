package com.lulu.mapper.modules.selecao_curso

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lulu.mapper.R
import com.lulu.mapper.model.CardCursoAdapter
import com.lulu.mapper.model.CardUfCursoAdapter
import com.lulu.mapper.model.CursoItem
import com.lulu.mapper.model.UnidadeFederativaItem
import com.lulu.mapper.repositories.CalculadoraRepository
import com.lulu.mapper.rest.CalculadoraService
import com.lulu.mapper.viewmodel.curso.CursoViewModel
import com.lulu.mapper.viewmodel.curso.CursoViewModelFactory
import com.lulu.mapper.viewmodel.ufs.UfViewModel
import com.lulu.mapper.viewmodel.ufs.UfViewModelFactory

class SelecaoCurso : Fragment() {
    private lateinit var cursoVM: CursoViewModel
    lateinit var searchView: androidx.appcompat.widget.SearchView
    private val calculadoraService = CalculadoraService.getInstance()

    private val adapter = CardCursoAdapter {

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_uf, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerUf)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        cursoVM = ViewModelProvider(
            this,
            CursoViewModelFactory(CalculadoraRepository(calculadoraService))
        )[CursoViewModel::class.java]

        recyclerView.adapter = adapter

        searchView = view.findViewById(R.id.searchView)


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrBlank()){
                    filter(newText)
                } else{
                    cursoVM.getAllCursos()
                }
                return false
            }
        })


        return view
    }

    override fun onStart() {
        super.onStart()
        cursoVM.cursoList.observe(this) {
            adapter.setCursoList(it)
        }
        cursoVM.errorMessage.observe(this) {
            Log.i("Lulutag", it)
        }

    }

    override fun onResume() {
        super.onResume()
        cursoVM.getAllCursos()
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<CursoItem> = ArrayList()

        // running a for loop to compare elements.
        for (item in cursoVM.cursoList.value!!.toList()) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.curso.lowercase().contains(text.lowercase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(activity, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.setCursoList(filteredlist)
        }
    }


}