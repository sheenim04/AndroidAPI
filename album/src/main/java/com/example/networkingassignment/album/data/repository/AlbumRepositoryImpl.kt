package com.example.networkingassignment.album.data.repository

import com.example.networkingassignment.album.data.cache.AlbumCacheSource
import com.example.networkingassignment.album.data.remote.AlbumRemoteSource
import com.example.networkingassignment.album.domain.model.Albums
import com.example.networkingassignment.album.domain.repository.AlbumRepository

class AlbumRepositoryImpl(val remote: AlbumRemoteSource, val cache: AlbumCacheSource) :
    AlbumRepository {

    override suspend fun getAlbums(): List<Albums> {
        if(cache.album.isNotEmpty()){
            return cache.album
        }

        val albums = remote.getAlbums()
        cache.album = albums
        return albums
    }

    override suspend fun getAlbum(albumId: Int): Albums {
        val album = remote.getAlbum(albumId)
        return album
    }
}