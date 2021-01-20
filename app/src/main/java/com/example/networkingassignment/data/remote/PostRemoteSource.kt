package com.example.networkingassignment.data.remote

import com.example.networkingassignment.domain.model.Posts

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
}