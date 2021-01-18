package com.example.networkingassignment


import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): List<Posts>

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Posts>

    @POST("/posts")
    suspend fun createPost(@Body body: PostRequest): List<Posts>

    @PUT("/posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body body: PostRequest): List<Posts>
}

