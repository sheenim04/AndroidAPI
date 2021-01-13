package com.example.networkingassignment

import kotlinx.serialization.Serializable

@Serializable
data class Posts (
    var userId : Int,
    var id : Int,
    var title : String,
    var body : String
)