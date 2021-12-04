package ru.netology.nmedia.utils

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.utils.adapter.ActionListener
import ru.netology.nmedia.utils.adapter.PostsAdapter
import ru.netology.nmedia.utils.viewmodd.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel:PostViewModel by viewModels()
        val adapter = PostsAdapter(object: ActionListener {
            override fun onLike(post: Post) {
                viewModel.likeById(post.id)
            }
            override fun   onShare(post: Post) {
                viewModel.share(post.id)
            }

        }

            )

        binding.list.adapter = adapter
        viewModel.data.observe(
            this){
            posts -> adapter.submitList(posts)

            }


        }



}












