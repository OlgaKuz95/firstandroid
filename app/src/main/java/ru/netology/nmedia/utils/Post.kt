package ru.netology.nmedia.utils



data class Post(
    val id: Int,
    val author: String,
    val text:String,
    val published:String,
    val likedByMe: Boolean=false,
    var likeCount:Int,
    var shareCount:Int,
    )
