package ru.netology.nmedia.utils.hold

import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.utils.Post
import ru.netology.nmedia.utils.adapter.ActionListener


class PostViewHolder(
    private val binding: CardPostBinding,
    private val actionListener: ActionListener,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            text.text = post.content
            imageLike.setImageResource(
                if (post.likedByMe) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
            )
            share.setImageResource(R.drawable.ic_baseline_share_24)

            menu.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.options_post)
                    setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.remove -> {
                                actionListener.onRemove(post)
                                true
                            }
                            R.id.edit -> {
                                actionListener.onEdit(post)
                                true
                            }
                            R.id.imageLike -> {
                                actionListener.onLike(post)
                                true
                            }
                            R.id.cancel_button ->{
                                actionListener.onCancelEdit(post)
                                true
                            }
                            else -> false
                        }
                    }
                }.show()
            }


            imageLike.setOnClickListener {
                actionListener.onLike(post)
            }
            share.setOnClickListener {
                actionListener.onShare(post)
            }
        }
    }
}