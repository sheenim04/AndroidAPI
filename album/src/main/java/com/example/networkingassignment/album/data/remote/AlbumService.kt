package com.example.networkingassignment.album.data.remote

import com.example.networkingassignment.album.domain.model.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<Albums>>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): Response<Albums>
}