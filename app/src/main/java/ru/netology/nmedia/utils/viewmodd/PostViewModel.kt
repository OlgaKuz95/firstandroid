package ru.netology.nmedia.utils.viewmodd

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.utils.repository.PostRepository
import ru.netology.nmedia.utils.repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
    fun likeById(id: Long) = repository.likeById(id)
    fun share(id: Long)=repository.share(id)

}