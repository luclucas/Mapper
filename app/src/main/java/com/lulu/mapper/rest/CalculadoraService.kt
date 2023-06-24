package com.lulu.mapper.rest

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lulu.mapper.model.UnidadeFederativaItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface CalculadoraService {


    @GET("uf")
    fun getAllUfs(): Call<List<UnidadeFederativaItem>>

    companion object{

        private const val BASE:String = "http://18.233.181.140:8000/hmlg/calculadora/"
        private val calculadoraService: CalculadoraService by lazy{

            val gson: Gson = GsonBuilder()
                .setLenient()
                .create()
// ...
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            retrofit.create(CalculadoraService::class.java)


        }
        fun getInstance(): CalculadoraService{
            return calculadoraService
        }
    }
}
