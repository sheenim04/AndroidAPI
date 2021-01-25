package com.example.networkingassignment.post.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.networkingassignment.post.R
import com.example.networkingassignment.post.domain.model.Posts
import kotlinx.android.synthetic.main.fragment_create_post.*
import kotlinx.coroutines.MainScope
import java.lang.Integer.parseInt

class CreatePostFragment() : Fragment() {

    val scope = MainScope()
    private val viewModelFactory: CreateViewModelFactory by lazy { CreateViewModelFactory() }
    private val viewModel: CreateViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
    
        return inflater.inflate(R.layout.fragment_create_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirmPost.setOnClickListener {
            val newUserId = parseInt(et_create_userID.text.toString())
            val newId = parseInt(et_create_ID.text.toString())
            val newTitle = et_create_title.text.toString()
            val newBody = et_create_body.text.toString()

            viewModel.createNewPost(newUserId, newId, newTitle, newBody)
            viewModel.create.observe(viewLifecycleOwner){
                val post = it
                toastNewPost(post)

            }
        }
    }




        private fun toastNewPost(new: Posts) {
            Toast.makeText(requireContext(), "Post ID: ${new.id} , Title: ${new.title}, Body: ${new.body}", Toast.LENGTH_SHORT).show()
        }

}