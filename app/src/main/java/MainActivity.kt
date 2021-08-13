import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ru.netology.nmedia.R
import ru.netology.nmedia.utils.Calculator
import ru.netology.nmedia.utils.Post

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(
            getString(R.string.some_name),
            false,
            false,
            0,
            0
        )

        val likesView = findViewById<ImageView>(R.id.image_like)
        val likes = findViewById<TextView>(R.id.image_like)
        likesView.setOnClickListener {
            post.liked = !post.liked
            if (post.liked) post.likes++ else post.likes--
            likes.text = Calculator.convert(post.likes)
            likesView.setImageResource(getImageResource(post))

        }
        val shareView = findViewById<ImageView>(R.id.share)
        val share = findViewById<TextView>(R.id.share)
        shareView.setOnClickListener {
            post.shared = !post.shared
            if (post.shared) post.share++ else post.share--
            share.text = Calculator.convert(post.share)
            shareView.setImageResource(getImageShare(post))
        }
    }

    private fun getImageResource(post: Post) =
        if (post.liked) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24

    private fun getImageShare(post: Post) =
        if (post.shared) R.drawable.ic_baseline_share_24 else R.drawable.ic_baseline_share_24
}
