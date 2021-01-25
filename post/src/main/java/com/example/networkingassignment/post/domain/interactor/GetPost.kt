package com.example.networkingassignment.post.domain.interactor

import com.example.networkingassignment.post.domain.model.Posts
import com.example.networkingassignment.post.domain.repository.PostRepository

class GetPost(val repository: PostRepository) {


    suspend operator fun invoke(postId: Int): Posts {
        return repository.getPost(postId)
    }
}