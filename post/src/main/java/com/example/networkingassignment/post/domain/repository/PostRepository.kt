package com.example.networkingassignment.post.domain.repository

import com.example.networkingassignment.post.domain.model.Posts
import retrofit2.http.Body

interface PostRepository {

    suspend fun getPosts(): List<Posts>

    suspend fun getPost(postId: Int): Posts

    suspend fun createPost(userId: Int, id: Int, title: String, body: String): Posts

    suspend fun updatePost(postId: Int, @Body body: String) : Posts
}