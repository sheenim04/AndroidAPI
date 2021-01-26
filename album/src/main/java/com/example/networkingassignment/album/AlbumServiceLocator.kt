package com.example.networkingassignment.album

import com.example.networkingassignment.album.data.cache.AlbumCacheSource
import com.example.networkingassignment.album.data.remote.AlbumRemoteSource
import com.example.networkingassignment.album.data.remote.AlbumService
import com.example.networkingassignment.album.data.repository.AlbumRepositoryImpl
import com.example.networkingassignment.album.domain.interactor.CreateAlbum
import com.example.networkingassignment.album.domain.interactor.GetAlbum
import com.example.networkingassignment.album.domain.interactor.GetAlbums
import com.example.networkingassignment.common.CommonServiceLocator
import retrofit2.create

object AlbumServiceLocator {

    private val albumService: AlbumService = CommonServiceLocator.service.create()
    private val albumRemoteSource = AlbumRemoteSource(albumService)
    private val albumCacheSource = AlbumCacheSource()
    private val albumRepository = AlbumRepositoryImpl(albumRemoteSource, albumCacheSource)

    val getAlbums = GetAlbums(albumRepository)
    val getAlbum = GetAlbum(albumRepository)
    val createAlbum = CreateAlbum(albumRepository)
}