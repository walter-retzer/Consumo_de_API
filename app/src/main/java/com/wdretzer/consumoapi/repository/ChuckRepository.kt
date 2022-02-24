package com.wdretzer.consumoapi.repository

import com.wdretzer.consumoapi.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ChuckRepository(private val api: ChuckApi = ChuckApi.api) {
    fun joke(): Flow<Joke> = flow {
        emit(api.joke())
    }.flowOn(Dispatchers.IO)

    companion object{
        val instance: ChuckRepository by lazy { ChuckRepository() }
    }
}
