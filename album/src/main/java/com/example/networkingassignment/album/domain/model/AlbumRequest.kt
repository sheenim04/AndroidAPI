package com.example.networkingassignment.album.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AlbumRequest (
        val userId: Int,
        val id: Int,
        val title: String
        )