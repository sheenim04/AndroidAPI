package com.example.networkingassignment.data.repository

import com.example.networkingassignment.data.cache.PostCacheSource
import com.example.networkingassignment.data.remote.PostRemoteSource
import com.example.networkingassignment.domain.model.Posts
import com.example.networkingassignment.domain.repository.PostRepository
import com.example.networkingassignment.presentation.PostDetailsFragment

class PostRepositoryImpl(val remote: PostRemoteSource, val cache: PostCacheSource) : PostRepository {

    override suspend fun getPosts(): List<Posts> {
        if (cache.posts.isNotEmpty()){
            return cache.posts
        }
        val posts = remote.getPosts()
        cache.posts = posts
        return posts
    }

    override suspend fun getPost(postId: Int): Posts {
        val post = remote.getPost(postId)
        //   cache.post = post
        return post
    }

    override suspend fun createPost(userId: Int, id: Int, title: String, body: String): Posts {
        val post = remote.createPost(userId, id, title, body)
        return post
    }

}