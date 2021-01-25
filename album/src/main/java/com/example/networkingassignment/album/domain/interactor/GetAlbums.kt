package com.example.networkingassignment.album.domain.interactor

import com.example.networkingassignment.album.domain.model.Albums
import com.example.networkingassignment.album.domain.repository.AlbumRepository

class GetAlbums(val repository: AlbumRepository) {

    suspend operator fun invoke(): List<Albums>{
        return repository.getAlbums()
    }
}