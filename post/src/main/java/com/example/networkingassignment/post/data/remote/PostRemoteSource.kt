package com.example.networkingassignment.post.data.remote

import com.example.networkingassignment.post.domain.model.PostRequest
import com.example.networkingassignment.post.domain.model.Posts


class PostRemoteSource(val service: PostService) {


    suspend fun getPosts(): List<Posts> {
        val response = service.getPosts()
        val data = response.body()


        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }
    }

    suspend fun getPost(postId: Int): Posts {
        val response = service.getPost(postId)
        val data = response.body()


        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }
    }


    suspend fun createPost(userId: Int, id: Int, title: String, body: String): Posts {
        val response = service.createPost(PostRequest(userId, id, title, body))
        val data = response.body()

        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }

    }

    suspend fun updatePost(postId: Int,  body: String) : Posts {
        val response = service.updatePost(postId, body )
        val data = response.body()

        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }
    }
}