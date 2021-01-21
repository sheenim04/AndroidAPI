package com.example.networkingassignment.domain.interactor

import com.example.networkingassignment.domain.model.Posts
import com.example.networkingassignment.domain.repository.PostRepository

class CreatePost(val repository: PostRepository) {

    suspend operator fun invoke(userId: Int, id: Int, title: String, body: String): Posts {
        return repository.createPost(userId, id, title, body)
    }
}