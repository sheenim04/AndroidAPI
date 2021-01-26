package com.example.networkingassignment.album.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.networkingassignment.album.R
import com.example.networkingassignment.album.domain.model.Albums
import kotlinx.android.synthetic.main.fragment_album_details.*

class AlbumDetailsFragment : Fragment() {

    val args: AlbumDetailsFragmentArgs by navArgs()
    private val viewModelFactory: AlbumDetailsViewModelFactory by lazy { AlbumDetailsViewModelFactory() }
    private val viewModel: AlbumDetailsViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_album_details, container, false)

        view.findViewById<Button>(R.id.btnAlbum_create).setOnClickListener {
            findNavController().navigate(R.id.action_albumDetailsFragment_to_createAlbumFragment)
        }

        view.findViewById<Button>(R.id.btnAlbum_update).setOnClickListener {
            val action = AlbumDetailsFragmentDirections.actionAlbumDetailsFragmentToUpdateAlbumFragment(args.albumId)
            findNavController().navigate(action)
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadAlbumDetails(args.albumId)
        viewModel.detailAlbum.observe(viewLifecycleOwner) {
            val album = it
            setAlbumDetails(album)
        }
    }


    private fun setAlbumDetails(albumDetails: Albums){
        if(albumDetails != null){
            albumdetails_userId.text = albumDetails.userId.toString()
            albumdetails_id.text = albumDetails.id.toString()
            albumdetails_title.text = albumDetails.title
        }
    }
}