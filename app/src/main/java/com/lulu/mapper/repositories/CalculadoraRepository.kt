package com.lulu.mapper.repositories

import com.lulu.mapper.rest.CalculadoraService

class CalculadoraRepository constructor(private val calculadoraService: CalculadoraService){

    fun getAllUfs() = calculadoraService.getAllUfs()
}