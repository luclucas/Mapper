package com.lulu.mapper.viewmodel.ufs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lulu.mapper.model.UnidadeFederativa
import com.lulu.mapper.model.UnidadeFederativaItem
import com.lulu.mapper.repositories.CalculadoraRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UfViewModel constructor(private val repository: CalculadoraRepository): ViewModel(){

    val ufList = MutableLiveData<List<UnidadeFederativaItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllUfs(){
         val request = repository.getAllUfs()
        request.enqueue(object : Callback<List<UnidadeFederativaItem>>{
            override fun onResponse(
                call: Call<List<UnidadeFederativaItem>>,
                response: Response<List<UnidadeFederativaItem>>
            ) {
               ufList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UnidadeFederativaItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }
}