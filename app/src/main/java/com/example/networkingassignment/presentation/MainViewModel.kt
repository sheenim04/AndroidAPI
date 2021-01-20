package com.example.networkingassignment.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.ServiceLocator
import com.example.networkingassignment.domain.interactor.GetPost
import com.example.networkingassignment.domain.interactor.GetPosts
import com.example.networkingassignment.domain.model.Posts
import kotlinx.coroutines.launch

class MainViewModel(val getPosts: GetPosts): ViewModel() {

    private val _posts = MutableLiveData<List<Posts>>()
    val posts: LiveData<List<Posts>>
        get() = _posts


    fun load(){
        viewModelScope.launch {
            _posts.value = getPosts()
        }
    }


    companion object{
        fun create() = MainViewModel(ServiceLocator.getPosts)
    }

}