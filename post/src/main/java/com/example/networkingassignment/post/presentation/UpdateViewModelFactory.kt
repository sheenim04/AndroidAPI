package com.example.networkingassignment.post.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UpdateViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel.create() as T
    }

}