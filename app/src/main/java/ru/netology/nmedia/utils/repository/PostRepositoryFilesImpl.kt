package ru.netology.nmedia.utils.repository



import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.netology.nmedia.utils.Post
import ru.netology.nmedia.utils.viewmodd.empty

class PostRepositoryFilesImpl(private val context: Context) : PostRepository {
    private var nextId = 1L
    private val gson = Gson()
    private val typeToken = TypeToken.getParameterized(List::class.java, Post::class.java).type
    private val filename = "posts.json"
    private var posts = emptyList<Post>()

set(value) {
    field = value
    sync()
}


    private val data = MutableLiveData(posts)

    init {
        val file = context.filesDir.resolve(filename)
        if (file.exists()){
            context.openFileInput(filename).bufferedReader().use {
                posts =gson.fromJson(it, typeToken)
                nextId = posts.maxOfOrNull { post -> post.id }?.inc() ?:1
                data.value = posts
            }}
            else{
                sync()
        }

        }

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
            sync()
            return
        }
        posts = posts.map {
            if (it.id != post.id) it else it.copy(content = post.content)
        }
        data.value = posts
    }

    private fun sync(){
      context.openFileOutput(filename, Context.MODE_PRIVATE).bufferedWriter().use {
          it.write(gson.toJson(posts))
      }
        }
    }




