package com.example.networkingassignment.album.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.networkingassignment.album.R
import com.example.networkingassignment.album.domain.model.Albums
import kotlinx.android.synthetic.main.fragment_create_album.*
import java.lang.Integer.parseInt

class CreateAlbumFragment : Fragment() {

    private val viewModelFactory: CreateAlbumViewModelFactory by lazy { CreateAlbumViewModelFactory()}
    private val viewModel: CreateAlbumViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirmAlbum.setOnClickListener {
            val newUserId = parseInt(et_create_userID.text.toString())
            val newId = parseInt(et_create_ID.text.toString())
            val newTitle = et_create_title.text.toString()

            viewModel.createNewAlbum(newUserId, newId, newTitle)
            viewModel.createAlb.observe(viewLifecycleOwner){
                val album = it
                toastNewAlbum(album)
            }
        }
    }


    private fun toastNewAlbum(new: Albums){
        Toast.makeText(requireContext(), "Post ID: ${new.id}, Title: ${new.title}", Toast.LENGTH_SHORT).show()
    }

}