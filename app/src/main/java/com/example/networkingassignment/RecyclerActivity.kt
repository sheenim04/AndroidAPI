package com.example.networkingassignment


import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import retrofit2.*

class RecyclerActivity : BaseActivity(R.layout.activity_recycler) {
    val scope = MainScope()

    private lateinit var nameController: NameController

    override fun start() {
        initController()
        scope.launch {
            try{
                loadData()
            }
            catch (e: Exception){
                Toast.makeText(this@RecyclerActivity, "Exception occurred: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun initController() {
        nameController = NameController()
        recycler_view.setLayoutManager(LinearLayoutManager(this))
        recycler_view.setControllerAndBuildModels(nameController)
    }


    private suspend fun loadData(){
        val post  = withContext(Dispatchers.IO){ getPost() }
        addPostList(post)
    }

    private suspend fun getPost() : List<Posts> {
        val response = ApiClient.client.getPosts()

        if(response != null){
            return response
        }
        else{
            throw Exception(response[0].title)
        }
    }

    fun addPostList(listOfPosts : List<Posts>) {
       /* val listOfBodies = mutableListOf<String>()
        val listOfUserIds = mutableListOf<Int>()
        val listOfIds = mutableListOf<Int>()
        val listOfTitles = mutableListOf<String>()

        for(post in listOfPosts){
            listOfUserIds.add(post.userId)
            listOfIds.add(post.id)
            listOfTitles.add(post.title)
            listOfBodies.add(post.body)
        }*/
        nameController.setPosts(listOfPosts)
    }

}


