package com.example.networkingassignment.data.remote

import androidx.navigation.fragment.navArgs
import com.example.networkingassignment.data.repository.PostRepositoryImpl
import com.example.networkingassignment.domain.interactor.GetPost
import com.example.networkingassignment.domain.model.PostRequest
import com.example.networkingassignment.domain.model.Posts
import com.example.networkingassignment.domain.repository.PostRepository
import com.example.networkingassignment.presentation.MainFragment
import com.example.networkingassignment.presentation.PostDetailsFragment
import kotlinx.android.synthetic.main.fragment_create_post.*


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


    suspend fun createPost(userId: Int, id: Int, title: String, body: String): Posts{
        val response = service.createPost(PostRequest(userId, id, title, body))
        val data = response.body()

        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }

    }
}