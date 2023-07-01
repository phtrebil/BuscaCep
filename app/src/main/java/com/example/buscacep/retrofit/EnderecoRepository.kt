package com.example.buscacep.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class EnderecoRepository {

    val resposta = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cepService = resposta.create(CepService::class.java)
}