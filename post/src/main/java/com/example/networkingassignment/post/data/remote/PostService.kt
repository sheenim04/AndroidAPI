package com.example.networkingassignment.post.data.remote

import com.example.networkingassignment.post.domain.model.PostRequest
import com.example.networkingassignment.post.domain.model.Posts
import retrofit2.Response
import retrofit2.http.*

interface PostService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Posts>>

    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Posts>

    @POST("/posts")
    suspend fun createPost(@Body body: PostRequest): Response<Posts>

    @PUT("/posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body body: String): Response<Posts>
}