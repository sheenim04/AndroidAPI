package com.example.networkingassignment.post.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.networkingassignment.post.R

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
    }

    companion object{
        fun newIntent(context: Context) = Intent(context, PostActivity::class.java)
    }
}