package com.example.networkingassignment.album.data.remote

import com.example.networkingassignment.album.domain.model.AlbumRequest
import com.example.networkingassignment.album.domain.model.Albums

class AlbumRemoteSource(val service: AlbumService) {

    suspend fun getAlbums(): List<Albums>{
        val response = service.getAlbums()
        val data = response.body()

        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }
    }

    suspend fun getAlbum(albumId: Int): Albums{
        val response = service.getAlbum(albumId)
        val data = response.body()

        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }
    }

    suspend fun createAlbum(userId: Int, id: Int, title: String) : Albums {
        val response = service.createAlbum(AlbumRequest(userId, id, title))
        val data = response.body()

        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }
    }
}