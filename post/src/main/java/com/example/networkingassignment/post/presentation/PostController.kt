package com.example.networkingassignment.post.presentation

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.example.networkingassignment.post.domain.model.Posts

class PostController(private val listener: (View, Int) -> Unit) : EpoxyController() {

    private  var names : List<Posts> = listOf()

    override fun buildModels() {

        names.let {
            it.forEachIndexed { index, name ->
                PostItemModel_()
                        .id(index)
                        .userId(name.userId)
                        .p_id(name.id)
                        .title(name.title)
                        .body(name.body)
                        .clickListener{ model, _, view, _ ->
                            listener.invoke(view, model.p_id())
                        }
                        .addTo(this)
            }
        }
    }

    fun setPosts(name: List<Posts>) {
        names = name
        requestModelBuild()
    }

}