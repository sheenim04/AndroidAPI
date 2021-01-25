package com.example.networkingassignment.album.data.remote

import com.example.networkingassignment.album.domain.model.Albums
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<Albums>>
}