package com.example.buscacep.retrofit

import com.example.buscacep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {

    @GET("{cep}/json")
    suspend fun buscaEndereco(@Path("cep") cep: String): Endereco
}