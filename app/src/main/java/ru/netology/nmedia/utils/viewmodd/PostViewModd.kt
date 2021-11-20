package ru.netology.nmedia.utils.viewmodd

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.utils.repository.PostRepository
import ru.netology.nmedia.utils.repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun imageLike() = repository.imageLike()
    fun share()=repository.share()

}