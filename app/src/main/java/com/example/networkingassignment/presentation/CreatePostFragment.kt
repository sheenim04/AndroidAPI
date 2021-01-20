package com.example.networkingassignment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.networkingassignment.domain.model.PostRequest
import com.example.networkingassignment.R
import com.example.networkingassignment.data.remote.PostService
import com.example.networkingassignment.domain.model.Posts
import kotlinx.android.synthetic.main.fragment_create_post.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Integer.parseInt

class CreatePostFragment(val service: PostService) : Fragment() {

    val scope = MainScope()
    private lateinit var postController: PostController

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_create_post, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirmPost.setOnClickListener {
            scope.launch {
                try {
                    loadNewPost()
                } catch (e: Exception) {
                    Toast.makeText(
                        requireContext(),
                        "Exception occurred: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    suspend fun loadNewPost(){
        val newPost = withContext(Dispatchers.IO){ getNewPost()}
        setNewPost(newPost)
    }


     suspend fun getNewPost() : List<Posts> {
         val newUserId = parseInt(et_create_userID.text.toString())
         val newId = parseInt(et_create_ID.text.toString())
         val newTitle = et_create_title.text.toString()
         val newBody = et_create_body.text.toString()

         val response = service.createPost(PostRequest(newUserId, newId, newTitle, newBody))

         return if(response != null){
             response
         } else{
             throw Exception("Error")
         }
    }

    private fun setNewPost(post:List<Posts>){
        postController.setPosts(post)
    }

}