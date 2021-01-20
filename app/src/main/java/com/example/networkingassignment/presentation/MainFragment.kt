package com.example.networkingassignment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networkingassignment.R
import com.example.networkingassignment.data.remote.PostRemoteSource
import com.example.networkingassignment.data.remote.PostService
import kotlinx.android.synthetic.main.activity_recycler.*


class MainFragment : Fragment() {

    private lateinit var postController: PostController
    private val viewModelFactory: MainViewModelFactory by lazy { MainViewModelFactory() }
    private val viewModel: MainViewModel by viewModels { viewModelFactory }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
         return inflater.inflate(R.layout.fragment_main, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initController()
        viewModel.load()
        viewModel.posts.observe(viewLifecycleOwner){
            val post = it
            postController.setPosts(post)
        }
    }

    fun initController() {

        val clickListener: (View, Int) -> Unit = { view, id ->
            //Toast.makeText(requireContext(), "Navigate to Details Page, Post ID: $id", Toast.LENGTH_SHORT).show()
            val post = id
            val action = MainFragmentDirections.actionMainFragmentToPostDetailsFragment(post)
            findNavController().navigate(action)
        }

        postController = PostController(clickListener)
        recycler_view.setLayoutManager(LinearLayoutManager(requireContext()))
        recycler_view.setControllerAndBuildModels(postController)
    }



}