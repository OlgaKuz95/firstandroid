package ru.netology.nmedia.utils.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia.utils.Post

interface PostRepository{
fun get(): LiveData<Post>
fun imageLike()
fun share()
}