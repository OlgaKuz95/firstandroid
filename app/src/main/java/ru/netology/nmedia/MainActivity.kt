package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(
            getString(R.string.sample_text),
            false,
            false
        )

            val likesView = findViewById<ImageView>(R.id.image_like)
        likesView.setOnClickListener {
            post.liked = !post.liked
            likesView.setImageResource(getImageResource(post))

        }
        val shareView = findViewById<ImageView>(R.id.share)
        shareView.setOnClickListener{
            post.shared = !post.shared
            shareView.setImageResource(getImageShare(post))
        }
    }

    private fun getImageResource(post: Post) =
        if (post.liked) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24

private fun getImageShare(post: Post) =
    if(post.shared) R.drawable.ic_baseline_share_24 else TODO()
}