package ru.netology.nmedia.utils.hold

import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.utils.Post
import ru.netology.nmedia.utils.adapter.OnLikeListener
import ru.netology.nmedia.utils.adapter.OnShareListener

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener

): RecyclerView.ViewHolder(binding.root){
    fun bind(post: Post){
        binding.apply {
            author.text = post.author
            published.text = post.published
            text.text = post.text
            imageLike.setImageResource(
                if (post.likedByMe) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
                    )
           share.setImageResource(R.drawable.ic_baseline_share_24)

            imageLike.setOnClickListener{
               onLikeListener(post)
            }
           share.setOnClickListener{
                onShareListener(post)
           }
        }
    }
}