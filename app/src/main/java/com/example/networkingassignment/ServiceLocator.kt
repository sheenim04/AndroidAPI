package com.example.networkingassignment

import com.example.networkingassignment.data.cache.PostCacheSource
import com.example.networkingassignment.data.remote.PostRemoteSource
import com.example.networkingassignment.data.remote.PostService
import com.example.networkingassignment.data.repository.PostRepositoryImpl
import com.example.networkingassignment.domain.interactor.GetPosts
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object ServiceLocator {

    //Logging Interceptor
    private val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    //OkHttp Instance
     val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()


    //Retrofit Instance
    private val contentType = "application/json".toMediaType()
    private val service: PostService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
            .create()

    private val postRemoteSource = PostRemoteSource(service)
    private val postCacheSource = PostCacheSource()
    private val postRepository = PostRepositoryImpl(postRemoteSource, postCacheSource)

    val getPosts = GetPosts(postRepository)

}