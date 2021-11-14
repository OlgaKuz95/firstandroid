package ru.netology.nmedia.utils



data class Post(
    val id:Long,
    val author: String,
    val text:String,
    val published:String,
    var likedByMe: Boolean=false,
    )
