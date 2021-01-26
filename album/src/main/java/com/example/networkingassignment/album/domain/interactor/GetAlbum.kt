package com.example.networkingassignment.album.domain.interactor

import com.example.networkingassignment.album.domain.model.Albums
import com.example.networkingassignment.album.domain.repository.AlbumRepository

class GetAlbum(val repository: AlbumRepository) {

    suspend operator fun invoke(albumId: Int): Albums {
        return repository.getAlbum(albumId)
    }
}