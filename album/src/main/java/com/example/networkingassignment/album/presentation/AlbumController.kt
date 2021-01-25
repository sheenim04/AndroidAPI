package com.example.networkingassignment.album.presentation

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.example.networkingassignment.album.domain.model.Albums

class AlbumController(private val listener: (View, Int) -> Unit) : EpoxyController() {

    private  var albums : List<Albums> = listOf()

    override fun buildModels() {

        albums.let {
            it.forEachIndexed { index, album ->
                AlbumItemModel_()
                        .id(index)
                        .userId(album.userId)
                        .albumId(album.id)
                        .title(album.title)
                        .clickListener{ model, _, view, _ ->
                            listener.invoke(view, model.albumId())
                        }
                        .addTo(this)
            }
        }
    }

    fun setAlbums(album: List<Albums>) {
        albums = album
        requestModelBuild()
    }
}