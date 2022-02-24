package com.wdretzer.consumoapi.data

import retrofit2.http.*

interface Api {
    @POST("login")
    suspend fun login(@Body login: LoginRequest): LoginResponse

    @GET("doctor")
    suspend fun doctors(
        @Header("Authorization") autorization: String,
    ): List<DoctorsList>

    companion object {
        val api: Api by lazy {
            RetrofitFactory
            .build(false)
            .create(Api::class.java)
        }
    }
}

data class LoginRequest(val email: String, val password: String)

data class LoginResponse(val token: String)

data class DoctorsList(
    val id: String,
    val photo: String,
    val name: String,
    val specialization: String,
    val classification: Float,
    val views: Int
)
