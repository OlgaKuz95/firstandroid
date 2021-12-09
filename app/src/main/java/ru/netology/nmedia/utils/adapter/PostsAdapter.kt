package ru.netology.nmedia.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.utils.Post
import ru.netology.nmedia.utils.hold.PostViewHolder
interface ActionListener {
    fun onLike(post: Post){}
    fun onShare(post: Post){}
    fun onRemove(post:Post){}
    fun onEdit(post:Post){}
    fun onCancelEdit(post:Post){}
}


class PostsAdapter(
    private val actionListener: ActionListener,
    ) : ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, actionListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}




