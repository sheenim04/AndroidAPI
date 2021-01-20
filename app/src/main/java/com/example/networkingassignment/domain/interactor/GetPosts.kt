package com.example.networkingassignment.domain.interactor

import com.example.networkingassignment.domain.model.Posts
import com.example.networkingassignment.domain.repository.PostRepository

class GetPosts(val repository: PostRepository) {

    suspend operator fun invoke(): List<Posts> {
        return repository.getPosts()
    }
}