package ru.netology.nmedia.utils

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.utils.viewmodd.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel:PostViewModel by viewModels()
        viewModel.data.observe(
            this){
            post ->
            with(binding){
                author.text = post.author
                published.text = post.published
                text.text = post.text
                likeCount.text = Calculator.convert(post.likeCount)
               shareCount.text = Calculator.convert(post.shareCount)
                imageLike.setImageResource(
                    if (post.likedByMe) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)

          share.setImageResource(R.drawable.ic_baseline_share_24)
            }
        }

        binding.imageLike.setOnClickListener{
            viewModel.imageLike()
        }
binding.share.setOnClickListener{
    viewModel.share()
}
}

}












