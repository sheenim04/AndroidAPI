package com.example.networkingassignment.post.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.post.PostServiceLocator
import com.example.networkingassignment.post.domain.interactor.CreatePost
import com.example.networkingassignment.post.domain.model.Posts
import kotlinx.coroutines.launch

class CreateViewModel(val createPost: CreatePost) : ViewModel() {

    private val _create = MutableLiveData<Posts>()
    val create: LiveData<Posts>
    get() = _create


    fun createNewPost(userId: Int, id: Int, title: String, body: String){
        viewModelScope.launch {
            _create.value = createPost(userId, id, title, body)
        }
    }

    companion object{
        fun create() = CreateViewModel(PostServiceLocator.createPost)
    }
}