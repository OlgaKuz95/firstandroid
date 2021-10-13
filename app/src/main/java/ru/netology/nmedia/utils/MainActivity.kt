package ru.netology.nmedia.utils

//import kotlinx.android.synthetic.main.activity_main.*

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
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

        with(binding){
            author.text = post.author
            published.text=post.published
            text.text=post.text
            if(post.likedByMe){
                val like = findViewById<ImageView>(R.id.like)
                like?.setImageResource(R.drawable.ic_baseline_favorite_24)
            }



            like.setOnClickListener {
                post.likedByMe = !post.likedByMe
                val like = findViewById<ImageView>(R.id.like)
                like.setImageResource(
                    if (post.likedByMe)R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
                )
            }
    }
    }
}

