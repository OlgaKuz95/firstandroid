package ru.netology.nmedia.utils.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.utils.Post

class PostRepositoryInMemoryImpl: PostRepository{
    private var post = Post(
    id = 1,
    author = "Нетология. Университет интернет-профессий будущего",
    text = "Привет, это новая Нетология! Кода-то Нетология начиналась с интенс...",
    published = "21 мая в 18.36",
    likedByMe = false,
    likeCount = 0,
    shareCount = 0,
        )

    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun imageLike() {
        post = post.copy(likedByMe = !post.likedByMe)
        if (post.likedByMe) post.likeCount++ else post.likeCount--
        data.value = post
    }

    override fun share() {
        post = post.copy()
        post.shareCount++
        data.value = post
  }


}