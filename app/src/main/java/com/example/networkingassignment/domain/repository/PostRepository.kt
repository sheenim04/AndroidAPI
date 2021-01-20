package com.example.networkingassignment.domain.repository

import com.example.networkingassignment.domain.model.Posts
import retrofit2.Response

interface PostRepository {

    suspend fun getPosts(): List<Posts>

    suspend fun getPost(id: Int): Posts
}