package com.example.buscacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.example.buscacep.databinding.ActivityMainBinding
import com.example.buscacep.model.Endereco
import com.example.buscacep.retrofit.EnderecoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var endereco: Endereco? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Oculta o layout de informações de endereço inicialmente
        binding.constraintLayoutInfoEndereco.visibility = GONE

        binding.botaoBuscar.setOnClickListener {
            val cep = binding.cep.text.toString()

            // Inicia uma coroutine para executar a busca de endereço de forma assíncrona
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    // Chama a função suspensa para buscar o endereço
                    val endereco = EnderecoRepository().cepService.buscaEndereco(cep)

                    // Exibe o layout de informações de endereço quando a resposta é bem-sucedida
                    binding.constraintLayoutInfoEndereco.visibility = VISIBLE
                    binding.rua.text = endereco.rua
                    binding.bairro.text = endereco.bairro
                    binding.cidade.text = endereco.cidade
                    binding.estado.text = endereco.estado
                } catch (e: Exception) {
                    // Oculta o layout de informações de endereço se a resposta não for bem-sucedida
                    binding.constraintLayoutInfoEndereco.visibility = GONE
                    Toast.makeText(this@MainActivity, "Endereço não encontrado", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}

