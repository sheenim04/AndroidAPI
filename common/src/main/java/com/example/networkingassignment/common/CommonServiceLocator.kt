package com.example.networkingassignment.common

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object CommonServiceLocator {

    //Logging Interceptor
    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    //OkHttp Instance
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    //Retrofit Instance
    private val contentType = "application/json".toMediaType()
    val service = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(client)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()

}