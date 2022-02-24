package com.wdretzer.consumoapi.data

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface ChuckApi {
    @GET("jokes/random")
    suspend fun joke(): Joke

    companion object {
        val api: ChuckApi by lazy {
            RetrofitFactory
                .build(true)
                .create(ChuckApi::class.java)
        }
    }
}

data class Joke(
    @SerializedName("icon_url")
    val imagem: String,
    @SerializedName("value")
    val piada: String
)
