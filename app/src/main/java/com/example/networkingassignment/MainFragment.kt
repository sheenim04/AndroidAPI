package com.example.networkingassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler.*


class MainFragment : Fragment() {

    private lateinit var nameController: NameController
    private val viewModel: NetworkViewModel by viewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_main, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initController()
        viewModel.loadData()
        viewModel.data.observe(viewLifecycleOwner){
            val post = it
            nameController.setPosts(post)
        }
    }

    fun initController() {

        val clickListener: (View, Int) -> Unit = { view, id ->
            //Toast.makeText(requireContext(), "Navigate to Details Page, Post ID: $id", Toast.LENGTH_SHORT).show()
          var post = id
            val action = MainFragmentDirections.actionMainFragmentToPostDetailsFragment(post)
            findNavController().navigate(action)
        }

        nameController = NameController(clickListener)
        recycler_view.setLayoutManager(LinearLayoutManager(requireContext()))
        recycler_view.setControllerAndBuildModels(nameController)
    }



}