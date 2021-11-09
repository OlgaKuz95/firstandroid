package ru.netology.nmedia.utils

import kotlin.Int

data class Post(
    val id:Long,
    val author: String,
    val text:String,
    val published:String,
    var likedByMe: Boolean=false,
    var shared:Boolean,
   // val likeCount: Int,
    //val colshare : Int,
  //  var moreIv:Boolean = false,
  //  var  count:Int,

   // var colshare:Int,

    )
