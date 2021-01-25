package com.example.networkingassignment.album.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.networkingassignment.album.R

class AlbumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
    }


    companion object{
        fun newIntent(context: Context) = Intent(context, AlbumActivity::class.java)
    }
}