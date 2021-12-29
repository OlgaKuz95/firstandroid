package ru.netology.nmedia.utils



data class Post(
    val id: Long,
    val author: String,
    val content:String,
    val published:String,
    val likedByMe: Boolean=false,
    val SharedByMe: Boolean=false,
    var likeCount:Int,
    var shareCount:Int,
    )
