package com.lulu.mapper.viewmodel.ufs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lulu.mapper.repositories.CalculadoraRepository

class UfViewModelFactory constructor(private val repository: CalculadoraRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UfViewModel::class.java)){
            UfViewModel(this.repository) as T
        } else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }

}