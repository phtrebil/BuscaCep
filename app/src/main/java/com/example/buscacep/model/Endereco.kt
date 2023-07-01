package com.example.buscacep.model

import com.google.gson.annotations.SerializedName

data class Endereco(
    @SerializedName("logradouro")
    val rua: String,
    val bairro: String,
    @SerializedName("localidade")
    val cidade: String,
    @SerializedName("uf")
    val estado: String

)
