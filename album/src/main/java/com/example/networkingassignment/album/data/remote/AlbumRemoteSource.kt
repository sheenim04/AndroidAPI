package com.example.networkingassignment.album.data.remote

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
}