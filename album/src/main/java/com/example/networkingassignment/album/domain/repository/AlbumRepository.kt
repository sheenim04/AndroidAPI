package com.example.networkingassignment.album.domain.repository

import com.example.networkingassignment.album.domain.model.Albums

interface AlbumRepository {

    suspend fun getAlbums(): List<Albums>
}