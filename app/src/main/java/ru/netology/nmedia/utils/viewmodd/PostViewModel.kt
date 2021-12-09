package ru.netology.nmedia.utils.viewmodd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.utils.Post
import ru.netology.nmedia.utils.repository.PostRepository
import ru.netology.nmedia.utils.repository.PostRepositoryInMemoryImpl

private val empty = Post(
    id = 0,
    content = "",
    author = "",
    published = "",
    likedByMe = false,
    likeCount = 0,
    shareCount = 0,
)
class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
    val edited = MutableLiveData(empty)

fun save(){
    edited.value?.let{
        repository.save(it)
    }
    edited.value = empty
}
    fun edit(post: Post){
        edited.value = post
    }
    fun cancelEdit() {
        edited.value = empty

    }

    fun changeContent(content:String){
        val text = content.trim()
        if (edited.value?.content == text){
            return
        }
        edited.value = edited.value?.copy(content = text)
    }


    fun likeById(id: Long) = repository.likeById(id)
    fun share(id: Long)=repository.share(id)
    fun removeById(id: Long) = repository.removeById(id)
}