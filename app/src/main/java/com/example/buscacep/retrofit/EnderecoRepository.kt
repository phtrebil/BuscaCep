package com.example.buscacep.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EnderecoRepository {

    val resposta = Retrofit.Builder()
        .baseUrl("https://apinoticias.tedk.com.br/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}