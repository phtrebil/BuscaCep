package com.example.buscacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.botaoDeBusca.setOnClickListener {
            val call = EnderecoRepository().cepService.buscaEndereco(binding.cepEditText.text.toString())
                call.enqueue(object: Callback<Endereco>{
                    override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                        if (response.isSuccessful) {
                            val endereco = response.body()
                            binding.rua.text = endereco?.rua
                            binding.bairro.text = endereco?.bairro
                            binding.cidade.text = endereco?.cidade
                            binding.estado.text = endereco?.estado
                        } else {
                            Toast.makeText(this@MainActivity, "Endereço não encontrado", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Endereco>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Endereço não encontrado", Toast.LENGTH_SHORT).show()
                    }

                })
        }
    }
}