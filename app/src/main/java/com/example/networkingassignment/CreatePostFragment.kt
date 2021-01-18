package com.example.networkingassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_create_post.*
import kotlinx.android.synthetic.main.fragment_post_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.lang.Integer.parseInt
import java.net.URI.create

class CreatePostFragment : Fragment() {

    val scope = MainScope()
    private lateinit var nameController: NameController

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
                    findNavController().navigate(R.id.action_createPostFragment_to_mainFragment)
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


     suspend fun getNewPost() : List<Posts>{
         val userId = parseInt(et_create_userID.text.toString())
         val id = parseInt(et_create_ID.text.toString())
         val title = et_create_title.text.toString()
         val body = et_create_body.text.toString()

         val response = ApiClient.client.createPost(PostRequest(userId, id, title, body))

         if(response != null){
             return response
         }
         else{
             throw Exception("Error")
         }
    }

    private fun setNewPost(post: List<Posts>){
        nameController.setPosts(post)
    }

}