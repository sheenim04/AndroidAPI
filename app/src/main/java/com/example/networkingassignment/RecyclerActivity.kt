package com.example.networkingassignment

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.coroutines.*

class RecyclerActivity : BaseActivity(R.layout.activity_recycler) {
    val scope = MainScope()

    private lateinit var nameController: NameController
    private val viewModel: NetworkViewModel by viewModels()

    override fun start() {
        initController()
        viewModel.loadData()
        viewModel.data.observe(this){
            val post = it
            nameController.setPosts(post)
        }
    }

    fun initController() {
        val clickListener: (View, Int) -> Unit = { view, id ->
            Toast.makeText(this@RecyclerActivity, "Navigate to Details Page, Post ID: $id", Toast.LENGTH_SHORT).show()
        //    startActivity(Intent(this, MainFragment::class.java))
        }

        nameController = NameController(clickListener)
        recycler_view.setLayoutManager(LinearLayoutManager(this))
        recycler_view.setControllerAndBuildModels(nameController)
    }

}