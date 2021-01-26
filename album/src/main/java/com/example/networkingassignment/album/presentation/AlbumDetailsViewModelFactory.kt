package com.example.networkingassignment.album.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AlbumDetailsViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumDetailsViewModel.create() as T
    }

}