package com.example.networkingassignment.post.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.post.PostServiceLocator
import com.example.networkingassignment.post.domain.interactor.GetPost
import com.example.networkingassignment.post.domain.model.Posts
import kotlinx.coroutines.launch

class DetailsViewModel(val getPost: GetPost) : ViewModel() {


    private val _detail = MutableLiveData<Posts>()
    val detail: LiveData<Posts>
    get() = _detail

    fun loadDetails(postId: Int){
        viewModelScope.launch{
            _detail.value = getPost(postId)
        }
    }

    companion object{
        fun create() = DetailsViewModel(PostServiceLocator.getPost)
    }

}

