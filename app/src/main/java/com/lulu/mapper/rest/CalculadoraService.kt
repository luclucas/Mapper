package com.lulu.mapper.rest

import com.lulu.mapper.model.UnidadeFederativa
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CalculadoraService {


    @GET("/uf-controller/buscarTodosUsingGET_4")
    fun getAllUfs(): Call<UnidadeFederativa>

    companion object{
        val BASE:String = "http://18.233.181.140:8000/hmlg/calculadora/swagger-ui/index.html#/"
        private val calculadoraService: CalculadoraService by lazy{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(CalculadoraService::class.java)
        }
        fun getInstance(): CalculadoraService{
            return calculadoraService
        }
    }
}