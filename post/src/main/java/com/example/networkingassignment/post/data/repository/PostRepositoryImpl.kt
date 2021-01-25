package com.example.networkingassignment.post.data.repository

import com.example.networkingassignment.post.data.cache.PostCacheSource
import com.example.networkingassignment.post.data.remote.PostRemoteSource
import com.example.networkingassignment.post.domain.model.Posts
import com.example.networkingassignment.post.domain.repository.PostRepository

class PostRepositoryImpl(val remote: PostRemoteSource, val cache: PostCacheSource) :
    PostRepository {

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

    override suspend fun updatePost(postId: Int, body: String): Posts {
        val post = remote.updatePost(postId, body)
        return post
    }

}