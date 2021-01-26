package com.example.networkingassignment.album.domain.repository

import com.example.networkingassignment.album.domain.model.Albums

interface AlbumRepository {

    suspend fun getAlbums(): List<Albums>

    suspend fun getAlbum(albumId: Int): Albums

    suspend fun createAlbum(userId: Int, id: Int, title: String) : Albums
}