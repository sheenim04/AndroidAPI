package com.example.networkingassignment.album.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networkingassignment.album.R
import kotlinx.android.synthetic.main.activity_recycler.*


class AlbumFragment : Fragment() {

    private lateinit var albumController: AlbumController
    private val viewModelFactory: AlbumViewModelFactory by lazy { AlbumViewModelFactory()}
    private val viewModel: AlbumViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initController()
        viewModel.load()
        viewModel.albums.observe(viewLifecycleOwner){
            val albums = it
            albumController.setAlbums(albums)
        }
    }


    fun initController(){
        val clickListener: (View, Int) -> Unit = { view, id ->
            //Toast.makeText(requireContext(), "Navigate to Details Page, Post ID: $id", Toast.LENGTH_SHORT).show()
            val album = id
            val action = AlbumFragmentDirections.actionAlbumFragmentToAlbumDetailsFragment(album)
            findNavController().navigate(action)
        }

        albumController = AlbumController(clickListener)
        recycler_view.setLayoutManager(LinearLayoutManager(requireContext()))
        recycler_view.setControllerAndBuildModels(albumController)
    }

}