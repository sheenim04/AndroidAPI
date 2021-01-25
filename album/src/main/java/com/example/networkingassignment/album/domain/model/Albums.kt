package com.example.networkingassignment.album.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Albums(
    val userId: Int,
    val id: Int,
    val title: String
)