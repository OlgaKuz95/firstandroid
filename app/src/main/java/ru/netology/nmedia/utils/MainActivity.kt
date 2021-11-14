package ru.netology.nmedia.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
           id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            text = "Привет, это новая Нетология! Кода-то Нетология начиналась с интенс...",
            published = "21 мая в 18.36",
           likedByMe = false,
            )

        with(binding) {
           author.text = post.author
           published.text = post.published
          text.text = post.text
            likeCount.text = Calculator.convert(Calculator.likeCount)
            shareCount.text = Calculator.convert(Calculator.shareCount)

            imageLike.setImageResource(
                if (post.likedByMe) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
            )


            imageLike?.setOnClickListener {
               post.likedByMe = !post.likedByMe
                imageLike.setImageResource(
                    if (post.likedByMe) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
                )
                if (post.likedByMe) Calculator.likeCount++ else Calculator.likeCount--
                likeCount.text = Calculator.convert(Calculator.likeCount)
            }


            share?.setOnClickListener {
                share.setImageResource(R.drawable.ic_baseline_share_24 )
                Calculator.shareCount++
                shareCount.text = Calculator.convert(Calculator.shareCount)

            }
        }


    }
}











