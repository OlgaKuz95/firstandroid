package ru.netology.nmedia.utils.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia.utils.Post

interface PostRepository{
fun getAll():  LiveData<List<Post>>
fun likeById(id: Long)
fun share(id: Long)
}