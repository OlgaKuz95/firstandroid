package ru.netology.nmedia.utils

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.GONE
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.utils.adapter.ActionListener
import ru.netology.nmedia.utils.adapter.PostsAdapter
import ru.netology.nmedia.utils.util.AndroidUtils
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

            override fun onEdit(post: Post) {
                viewModel.edit(post)
            }

            override fun onRemove(post: Post) {
                viewModel.removeById(post.id)
            }

        }

            )

        binding.list.adapter = adapter
        viewModel.data.observe(
            this){
            posts -> adapter.submitList(posts)

            }
        viewModel.edited.observe(this){post ->
          if(post.id == 0L){
            //TODO  set visibility GONE (INVISIBLE) for cancel button
              group.visibility = View.GONE
              group.visibility = View.INVISIBLE
              return@observe
          }
            with(binding.content){
                requestFocus()
                setText(post.content)
                //TODO set visibility for cancel button
                group.visibility = View.VISIBLE
            }
        }



        //TODO setOnClickListener for cancel button
        viewModel.cancelEdit()

        binding.save.setOnClickListener {
            with(binding.content){
                if (text.isNullOrBlank()){
                    Toast.makeText(
                        this@MainActivity,
                        "Content can't be empty",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                viewModel.changeContent(text.toString())
                viewModel.save()

                setText("")
                clearFocus()
                AndroidUtils.hideKeyboard(this)
            }
        }


        }



}












