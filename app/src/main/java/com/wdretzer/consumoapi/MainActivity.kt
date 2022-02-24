package com.wdretzer.consumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.wdretzer.consumoapi.viewmodel.ApiViewModel
import com.wdretzer.consumoapi.viewmodel.ChuckViewModel


class MainActivity : AppCompatActivity() {

    private val viewModelApi: ApiViewModel by viewModels()
    private val viewModelChuck: ChuckViewModel by viewModels()

    private val textoJoke: TextView by lazy { findViewById(R.id.text_joke) }
    private val textoToken: TextView by lazy { findViewById(R.id.text_token) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chamadas()
        rendirizacoes()
    }

    private fun rendirizacoes() {
        observarChuck()
        observarApi()
    }

    private fun observarApi() {
        viewModelApi.error.observe(this) {
            if(it){
                textoToken.text = "Falha!!"
                Toast.makeText(this, "Falha!!", Toast.LENGTH_LONG).show()
            }

        }
        viewModelApi.success.observe(this) {
            textoToken.text = "Token: -> ${it}"
        }
    }

    private fun observarChuck() {
        viewModelChuck.error.observe(this) {
            if(it){
                textoJoke.text = "Falha!!"
                Toast.makeText(this, "Falha!", Toast.LENGTH_LONG).show()
            }

        }
        viewModelChuck.success.observe(this) {
            textoJoke.text = "Joke: -> ${it}"
        }
    }

    private fun chamadas() {
        viewModelApi.login("usuario@dhdoctor.com.br", "123456")
        viewModelChuck.joke()
    }
}
