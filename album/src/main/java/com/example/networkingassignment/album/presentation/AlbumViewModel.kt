package com.example.networkingassignment.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.album.AlbumServiceLocator
import com.example.networkingassignment.album.domain.interactor.GetAlbums
import com.example.networkingassignment.album.domain.model.Albums
import kotlinx.coroutines.launch

class AlbumViewModel(val getAlbums: GetAlbums) : ViewModel() {

    private val _albums = MutableLiveData<List<Albums>>()
    val albums: LiveData<List<Albums>>
    get() = _albums


    fun load(){
        viewModelScope.launch {
            _albums.value = getAlbums()
        }
    }

    companion object{
        fun create() = AlbumViewModel(AlbumServiceLocator.getAlbums)
    }
}