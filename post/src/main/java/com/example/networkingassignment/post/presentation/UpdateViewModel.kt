package com.example.networkingassignment.post.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingassignment.post.PostServiceLocator
import com.example.networkingassignment.post.domain.interactor.UpdatePost
import com.example.networkingassignment.post.domain.model.Posts
import kotlinx.coroutines.launch
import retrofit2.http.Body

class UpdateViewModel(val updatePost: UpdatePost) : ViewModel() {

    private val _update = MutableLiveData<Posts>()
    val update: LiveData<Posts>
    get() = _update


    fun updatePostBody(postId: Int, @Body body: String){
        viewModelScope.launch{
            _update.value = updatePost(postId, body)
        }
    }

    companion object{
        fun create() = UpdateViewModel(PostServiceLocator.updatePost)
    }
}