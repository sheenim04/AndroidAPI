package com.example.networkingassignment.domain.interactor

import com.example.networkingassignment.domain.model.Posts
import com.example.networkingassignment.domain.repository.PostRepository

class GetPost(val repository: PostRepository) {

    suspend operator fun invoke(postId: Int): Posts {
        return repository.getPost()
    }
}