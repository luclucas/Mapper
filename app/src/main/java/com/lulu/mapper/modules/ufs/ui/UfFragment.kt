package com.lulu.mapper.modules.ufs.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lulu.mapper.R
import com.lulu.mapper.model.CardUfCursoAdapter
import com.lulu.mapper.model.UnidadeFederativaItem
import com.lulu.mapper.repositories.CalculadoraRepository
import com.lulu.mapper.rest.CalculadoraService
import com.lulu.mapper.viewmodel.ufs.UfViewModel
import com.lulu.mapper.viewmodel.ufs.UfViewModelFactory
import java.util.Locale

class UfFragment : Fragment() {

    private lateinit var ufVM: UfViewModel
    lateinit var searchView: androidx.appcompat.widget.SearchView
    private val calculadoraService = CalculadoraService.getInstance()

    private val adapter = CardUfCursoAdapter {

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_uf, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerUf)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        ufVM = ViewModelProvider(
            this,
            UfViewModelFactory(CalculadoraRepository(calculadoraService))
        )[UfViewModel::class.java]

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
                    ufVM.getAllUfs()
                }
                return false
            }
        })


        return view
    }

    override fun onStart() {
        super.onStart()
        ufVM.ufList.observe(this) {
            adapter.setUfList(it)
        }
        ufVM.errorMessage.observe(this) {
            Log.i("Lulutag", it)
        }

    }

override fun onResume() {
    super.onResume()
    ufVM.getAllUfs()
}

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<UnidadeFederativaItem> = ArrayList()

        // running a for loop to compare elements.
        for (item in ufVM.ufList.value!!.toList()) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.uf.lowercase().contains(text.lowercase())) {
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
            adapter.setUfList(filteredlist)
        }
    }


companion object {

}
}