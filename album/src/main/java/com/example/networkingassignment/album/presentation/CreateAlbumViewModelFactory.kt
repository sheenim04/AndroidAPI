package com.example.networkingassignment.album.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateAlbumViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreateAlbumViewModel.create() as T
    }

}