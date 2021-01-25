package com.example.networkingassignment.post.domain.interactor

import com.example.networkingassignment.post.domain.model.Posts
import com.example.networkingassignment.post.domain.repository.PostRepository

class GetPosts(val repository: PostRepository) {

    suspend operator fun invoke(): List<Posts> {
        return repository.getPosts()
    }
}