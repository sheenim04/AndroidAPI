package com.example.networkingassignment.album.domain.interactor

import com.example.networkingassignment.album.domain.model.Albums
import com.example.networkingassignment.album.domain.repository.AlbumRepository

class CreateAlbum(val repository: AlbumRepository) {

    suspend operator fun invoke(userId: Int, id: Int, title: String) : Albums {
        return repository.createAlbum(userId, id, title)
    }
}
