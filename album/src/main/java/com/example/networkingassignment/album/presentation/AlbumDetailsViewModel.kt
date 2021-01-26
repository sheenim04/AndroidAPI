package com.example.networkingassignment.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.album.AlbumServiceLocator
import com.example.networkingassignment.album.domain.interactor.GetAlbum
import com.example.networkingassignment.album.domain.model.Albums
import kotlinx.coroutines.launch

class AlbumDetailsViewModel(val getAlbum: GetAlbum) : ViewModel() {

    private val _detailAlbum = MutableLiveData<Albums>()
    val detailAlbum: LiveData<Albums>
    get() = _detailAlbum


    fun loadAlbumDetails(albumId: Int){
        viewModelScope.launch {
            _detailAlbum.value = getAlbum(albumId)
        }
    }

    companion object{
        fun create() = AlbumDetailsViewModel(AlbumServiceLocator.getAlbum)
    }
}