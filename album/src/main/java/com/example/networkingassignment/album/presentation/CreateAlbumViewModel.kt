package com.example.networkingassignment.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.album.AlbumServiceLocator
import com.example.networkingassignment.album.domain.interactor.CreateAlbum
import com.example.networkingassignment.album.domain.model.Albums
import kotlinx.coroutines.launch

class CreateAlbumViewModel(val createAlbum: CreateAlbum) : ViewModel(){

    private val _createAlb = MutableLiveData<Albums>()
    val createAlb: LiveData<Albums>
    get() = _createAlb


    fun createNewAlbum(userId: Int, id: Int, title: String){
        viewModelScope.launch {
            _createAlb.value = createAlbum(userId, id, title)
        }
    }

    companion object{
        fun create() = CreateAlbumViewModel(AlbumServiceLocator.createAlbum)
    }
}