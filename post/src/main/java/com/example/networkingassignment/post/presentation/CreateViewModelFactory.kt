package com.example.networkingassignment.post.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreateViewModel.create() as T
    }

}