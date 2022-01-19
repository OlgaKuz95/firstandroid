package ru.netology.nmedia.utils.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.launch
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_post.*
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.utils.Post
import ru.netology.nmedia.utils.adapter.ActionListener
import ru.netology.nmedia.utils.adapter.PostsAdapter
import ru.netology.nmedia.utils.util.AndroidUtils
import ru.netology.nmedia.utils.viewmodd.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val newPostLauncher = registerForActivityResult(NewPostContract()){
            it?.let {
                viewModel.changeContent(it)
                viewModel.save()
            }
        }

        val newPostEdited = registerForActivityResult(NewPostContractEdited()){
            it?.let {
                viewModel.changeContent(it)
                viewModel.save()
            }
        }

        val adapter = PostsAdapter(object : ActionListener {
            override fun onLike(post: Post) {
                viewModel.likeById(post.id)
            }

            override fun onShare(post: Post) {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "*/*"
                    putExtra(Intent.EXTRA_TEXT, post.content)
                }
                val shareIntent = Intent.createChooser(intent, getString(R.string.chooser_share_post))
                startActivity(shareIntent)
            }

            override fun onEdit(post: Post) {
                viewModel.edit(post)
                newPostEdited.launch(post.content)
                }

            override fun onRemove(post: Post) {
                viewModel.removeById(post.id)

            }


        }

        )

        binding.list.adapter = adapter
        viewModel.data.observe( this,
        { posts ->
            adapter.submitList(posts)
        } )
        viewModel.edited.observe(this) { post ->
            if (post.id == 0L) {
                //TODO  set visibility GONE (INVISIBLE) for cancel button
                group.visibility = View.INVISIBLE

                return@observe
            }
            with(binding.content) {
                requestFocus()
                setText(post.content)
                //TODO set visibility for cancel button
               group.visibility = View.VISIBLE
            }
        }


        binding.cancelButton.setOnClickListener {
            viewModel.cancelEdit()

        }
        //TODO setOnClickListener for cancel button

        binding.save.setOnClickListener {
            newPostLauncher.launch()
        }

      /*  binding.save.setOnClickListener {
            with(binding.content) {
                if (text.isNullOrBlank()) {
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
        }*/


    }


}












