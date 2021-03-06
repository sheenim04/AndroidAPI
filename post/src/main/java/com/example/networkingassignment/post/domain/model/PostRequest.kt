package com.example.networkingassignment.post.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest (
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
        )