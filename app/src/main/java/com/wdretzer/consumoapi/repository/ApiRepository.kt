package com.wdretzer.consumoapi.repository

import com.wdretzer.consumoapi.data.Api
import com.wdretzer.consumoapi.data.LoginRequest
import com.wdretzer.consumoapi.data.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class ApiRepository(private val api: Api = Api.api) {
    fun login(email: String, password: String): Flow<LoginResponse> = flow {
        emit(Api.api.login(LoginRequest(email, password)))
    }.flowOn(Dispatchers.IO)

    companion object{
        val instance: ApiRepository by lazy { ApiRepository() }
    }
}
