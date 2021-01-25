package com.example.networkingassignment.post.domain.interactor

import com.example.networkingassignment.post.domain.model.Posts
import com.example.networkingassignment.post.domain.repository.PostRepository
import retrofit2.http.Body

class UpdatePost(val repository: PostRepository) {

    suspend operator fun invoke(postId: Int, @Body body: String) : Posts {
        return repository.updatePost(postId, body)
    }
}