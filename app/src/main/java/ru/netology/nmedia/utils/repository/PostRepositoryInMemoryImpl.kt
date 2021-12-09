package ru.netology.nmedia.utils.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.utils.Post

class PostRepositoryInMemoryImpl : PostRepository {
    private var nextId = 1L
    private var posts = listOf(
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Кода-то Нетология начиналась с интенс...",
            published = "21 мая в 18.36",
            likedByMe = false,
            likeCount = 0,
            shareCount = 0,
        ),

        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Кода-то Нетология начиналась с интенс...",
            published = "21 мая в 18.36",
            likedByMe = false,
            likeCount = 0,
            shareCount = 0,
        ),

        ).reversed()

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data


    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(likedByMe = !it.likedByMe)

        }


        data.value = posts
    }

    override fun share(id: Long) {

        posts = posts.map {
            it.copy(shareCount = it.shareCount++)

        }

        data.value = posts

    }

    override fun removeById(id: Long) {
        posts = posts.filter { it.id != id }
        data.value = posts
    }

    override fun save(post: Post) {
        if (post.id == 0L) {
            //TODO: remove hardcoded author & published
            posts = listOf(
                post.copy(
                    id = nextId++,
                    author = "Me",
                    likedByMe = false,
                    published = "now"
                )
            ) + posts
            data.value = posts
            return
        }
        posts = posts.map {
            if (it.id != post.id) it else it.copy(content = post.content)
        }
        data.value = posts
    }






}