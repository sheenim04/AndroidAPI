package com.example.networkingassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.networkingassignment.album.presentation.AlbumActivity
import com.example.networkingassignment.post.presentation.PostActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAlbum).setOnClickListener{
            startActivity(AlbumActivity.newIntent(this))
        }

        findViewById<Button>(R.id.btnPost).setOnClickListener {
            startActivity(PostActivity.newIntent(this))
        }

    }
}