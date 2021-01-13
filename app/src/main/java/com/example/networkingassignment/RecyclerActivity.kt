package com.example.networkingassignment

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
        nameController = NameController()
        recycler_view.setLayoutManager(LinearLayoutManager(this))
        recycler_view.setControllerAndBuildModels(nameController)
    }

}


