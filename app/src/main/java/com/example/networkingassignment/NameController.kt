package com.example.networkingassignment

import com.airbnb.epoxy.EpoxyController

class NameController : EpoxyController() {

   /* private var userIds : List<Int> = listOf()
    private var ids : List<Int> = listOf()
    private var titles : List<String> = listOf()*/
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
     /*   userIds = user
        ids = post_id
        titles = title*/
        names = name
        requestModelBuild()
    }

}