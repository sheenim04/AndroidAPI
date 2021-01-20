package com.example.networkingassignment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.networkingassignment.presentation.PostDetailsFragmentArgs
import com.example.networkingassignment.presentation.PostDetailsFragmentDirections
import com.example.networkingassignment.R
import com.example.networkingassignment.ServiceLocator
import com.example.networkingassignment.data.remote.PostService
import com.example.networkingassignment.domain.model.Posts
import kotlinx.android.synthetic.main.fragment_post_details.*
import kotlinx.coroutines.*


class PostDetailsFragment(val service: PostService) : Fragment() {

    val scope = MainScope()
    val args: PostDetailsFragmentArgs by navArgs()
    private val viewModelFactory: MainViewModelFactory by lazy { MainViewModelFactory() }
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_post_details, container, false)

        view.findViewById<Button>(R.id.btn_createPost).setOnClickListener {
            findNavController().navigate(R.id.action_postDetailsFragment_to_createPostFragment)
        }

        view.findViewById<Button>(R.id.btn_updatePost).setOnClickListener{
            val action = PostDetailsFragmentDirections.actionPostDetailsFragmentToUpdatePostFragment(args.postId)
            findNavController().navigate(action)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scope.launch {
            try {
                loadData()
            }

            catch(e:Exception){
                Toast.makeText(
                    requireContext(),
                    "Exception occurred: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }

    suspend fun loadData(){
        val details = withContext(Dispatchers.IO){ getDetails()}
        setDetails(details)
    }

    private suspend fun getDetails(): Posts {
        val response = service.getPost(args.postId)
        val data = response.body()


        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception(response.message())
        }

    }

    private fun setDetails(postDetails: Posts){
        if(postDetails != null){
            details_userID.text = postDetails.userId.toString()
            details_id.text = postDetails.id.toString()
            details_title.text = postDetails.title
            details_body.text = postDetails.body
        }
    }
}