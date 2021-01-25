package com.example.networkingassignment.post.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.post.PostServiceLocator
import com.example.networkingassignment.post.domain.interactor.GetPosts
import com.example.networkingassignment.post.domain.model.Posts
import kotlinx.coroutines.launch

class PostViewModel(val getPosts: GetPosts): ViewModel() {

    private val _posts = MutableLiveData<List<Posts>>()
    val posts: LiveData<List<Posts>>
        get() = _posts


    fun load(){
        viewModelScope.launch {
            _posts.value = getPosts()
        }
    }


    companion object{
        fun create() = PostViewModel(PostServiceLocator.getPosts)
    }

}