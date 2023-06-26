package com.lulu.mapper.viewmodel.curso

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lulu.mapper.repositories.CalculadoraRepository


class CursoViewModelFactory constructor(private val repository: CalculadoraRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CursoViewModel::class.java)){
            CursoViewModel(this.repository) as T
        } else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}