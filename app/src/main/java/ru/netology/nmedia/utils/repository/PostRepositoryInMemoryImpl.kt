package ru.netology.nmedia.utils.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.utils.Post

class PostRepositoryInMemoryImpl : PostRepository {
    private var posts = listOf(
        Post(
            id = 2,
            author = "Нетология. Университет интернет-профессий будущего",
            text = "Привет, это новая Нетология! Кода-то Нетология начиналась с интенс...",
            published = "21 мая в 18.36",
            likedByMe = false,
            likeCount = 0,
            shareCount = 0,
        ),

        Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            text = "Привет, это новая Нетология! Кода-то Нетология начиналась с интенс...",
            published = "21 мая в 18.36",
            likedByMe = false,
            likeCount = 0,
            shareCount = 0,
        ),

        )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data

    override fun likeById(id: Long) {
        posts = posts.map{
            if (it.id != id) it   else  it.copy(likedByMe = !it.likedByMe)

        }


        data.value = posts
    }

    override fun share(id: Long) {

        posts = posts.map{
            it.copy  (shareCount = it.shareCount++)

        }

        data.value = posts

    }


}