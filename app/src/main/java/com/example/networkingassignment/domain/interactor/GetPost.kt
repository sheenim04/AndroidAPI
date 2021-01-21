package com.example.networkingassignment.domain.interactor

import com.example.networkingassignment.data.remote.PostRemoteSource
import com.example.networkingassignment.domain.model.Posts
import com.example.networkingassignment.domain.repository.PostRepository
import com.example.networkingassignment.presentation.PostDetailsFragment

class GetPost(val repository: PostRepository) {


    suspend operator fun invoke(postId: Int): Posts {
        return repository.getPost(postId)
    }
}