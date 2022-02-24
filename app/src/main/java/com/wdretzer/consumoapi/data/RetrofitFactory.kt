package com.wdretzer.consumoapi.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun build(isChuckApi: Boolean = false): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(if (isChuckApi) "https://api.chucknorris.io/" else ("https://dh-digital-doctor-api.herokuapp.com/"))
            .build()

    }
}
