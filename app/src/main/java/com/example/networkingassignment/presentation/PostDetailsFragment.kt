package com.example.networkingassignment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
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


class PostDetailsFragment() : Fragment() {

    val scope = MainScope()
    val args: PostDetailsFragmentArgs by navArgs()
    private val viewModelFactory: DetailsViewModelFactory by lazy { DetailsViewModelFactory() }
    private val viewModel: DetailsViewModel by viewModels { viewModelFactory }

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

        viewModel.loadDetails(args.postId)
        viewModel.detail.observe(viewLifecycleOwner){
            val post = it
            setDetails(post)
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