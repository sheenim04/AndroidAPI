package com.example.networkingassignment.post

import com.example.networkingassignment.common.CommonServiceLocator
import com.example.networkingassignment.post.data.cache.PostCacheSource
import com.example.networkingassignment.post.data.remote.PostRemoteSource
import com.example.networkingassignment.post.data.remote.PostService
import com.example.networkingassignment.post.data.repository.PostRepositoryImpl
import com.example.networkingassignment.post.domain.interactor.CreatePost
import com.example.networkingassignment.post.domain.interactor.GetPost
import com.example.networkingassignment.post.domain.interactor.GetPosts
import com.example.networkingassignment.post.domain.interactor.UpdatePost

import retrofit2.create

object PostServiceLocator {

    private val postService: PostService = CommonServiceLocator.service.create()
    private val postRemoteSource = PostRemoteSource(postService)
    private val postCacheSource = PostCacheSource()
    private val postRepository = PostRepositoryImpl(postRemoteSource, postCacheSource)

    val getPosts = GetPosts(postRepository)
    val getPost = GetPost(postRepository)
    val createPost = CreatePost(postRepository)
    val updatePost = UpdatePost(postRepository)
}