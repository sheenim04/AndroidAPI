package com.example.networkingassignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NetworkViewModel: ViewModel() {

    private val _data = MutableLiveData<List<Posts>>()
    val data: LiveData<List<Posts>>
        get() = _data


    fun loadData(){
        viewModelScope.launch {
            _data.value = getData()
        }
    }

    private suspend fun getData(): List<Posts> = withContext(Dispatchers.IO){
        delay(1000L)
        val response = ApiClient.client.getPosts()

        if(response != null){
            return@withContext response
        }
        else{
            throw Exception(response[0].title)
        }
    }
}