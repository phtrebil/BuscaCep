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
            val call = EnderecoRepository().cepService.buscaEndereco(binding.cep.text.toString())

            // Faz uma chamada assíncrona à API para buscar o endereço com base no CEP fornecido
            call.enqueue(object : Callback<Endereco> {
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    if (response.isSuccessful) {
                        // Exibe o layout de informações de endereço quando a resposta é bem-sucedida
                        binding.constraintLayoutInfoEndereco.visibility = VISIBLE
                        endereco = response.body()
                        binding.rua.text = endereco?.rua
                        binding.bairro.text = endereco?.bairro
                        binding.cidade.text = endereco?.cidade
                        binding.estado.text = endereco?.estado
                    } else {
                        // Oculta o layout de informações de endereço se a resposta não for bem-sucedida
                        binding.constraintLayoutInfoEndereco.visibility = GONE
                        Toast.makeText(this@MainActivity, "Endereço não encontrado", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    // Oculta o layout de informações de endereço em caso de falha na chamada
                    binding.constraintLayoutInfoEndereco.visibility = GONE
                    Toast.makeText(this@MainActivity, "Endereço não encontrado", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}
