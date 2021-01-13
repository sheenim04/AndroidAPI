package com.example.networkingassignment

import com.airbnb.epoxy.EpoxyController

class NameController : EpoxyController() {

    private var names : List<Posts> = listOf()

    override fun buildModels() {

        names.let {
            it.forEachIndexed { index, name ->
                NameItemModel_()
                        .id(index)
                        .userId(name.userId)
                        .p_id(name.id)
                        .title(name.title)
                        .body(name.body)
                        .addTo(this)
            }
        }
    }

    fun setPosts(name: List<Posts>) {
        names = name
        requestModelBuild()
    }

}