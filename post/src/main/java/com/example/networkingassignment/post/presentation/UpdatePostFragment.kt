package com.example.networkingassignment.post.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.networkingassignment.post.R
import com.example.networkingassignment.post.domain.model.Posts
import kotlinx.android.synthetic.main.fragment_update_post.*


class UpdatePostFragment : Fragment() {

    val args: UpdatePostFragmentArgs by navArgs()
    private val viewModelFactory: UpdateViewModelFactory by lazy { UpdateViewModelFactory() }
    private val viewModel: UpdateViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirmUpdate.setOnClickListener {
            val newTitle = et_updateTitle.text.toString()
            val newBody = et_updateBody.text.toString()

            viewModel.updatePostBody(args.postIdToUpdate, newBody)
            viewModel.update.observe(viewLifecycleOwner){
                val post = it
                toastUpdate(post)
            }
        }
    }

    private fun toastUpdate(up: Posts){
        Toast.makeText(requireContext(), "Post ID: ${up.id} , Body: ${up.body}", Toast.LENGTH_SHORT).show()
    }
}