package com.example.networkingassignment.presentation

import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.ServiceLocator
import com.example.networkingassignment.domain.interactor.GetPost
import com.example.networkingassignment.domain.model.Posts
import kotlinx.coroutines.launch

class DetailsViewModel(val getPost: GetPost) : ViewModel() {


    private val _detail = MutableLiveData<Posts>()
    val detail: LiveData<Posts>
    get() = _detail

    fun loadDetails(){
        viewModelScope.launch{
            _detail.value = getPost(PostDetailsFragment().args.postId)
        }
    }

    companion object{
        fun create() = DetailsViewModel(ServiceLocator.getPost)
    }

}

