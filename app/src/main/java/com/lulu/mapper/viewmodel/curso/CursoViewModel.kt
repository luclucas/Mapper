package com.lulu.mapper.viewmodel.curso

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lulu.mapper.model.CursoItem
import com.lulu.mapper.repositories.CalculadoraRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CursoViewModel constructor(private val repository: CalculadoraRepository): ViewModel(){

    val cursoList = MutableLiveData<List<CursoItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCursos(){
        val request = repository.getAllCursos()
        request.enqueue(object : Callback<List<CursoItem>> {
            override fun onResponse(
                call: Call<List<CursoItem>>,
                response: Response<List<CursoItem>>
            ) {
                cursoList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CursoItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }
}