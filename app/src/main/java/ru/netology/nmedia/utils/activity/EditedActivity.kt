package ru.netology.nmedia.utils.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Context
import androidx.activity.result.contract.ActivityResultContract
import kotlinx.android.synthetic.main.activity_edited.*
import ru.netology.nmedia.databinding.ActivityEditedBinding

class EditedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveEdited.setOnClickListener{
        val text = binding.content.text.toString()
        if (text.isBlank()) {
            Toast.makeText(
                this@EditedActivity,
                "Content can't be empty",
                Toast.LENGTH_SHORT
            ).show()
            setResult(RESULT_CANCELED)
        }

        else {
            setResult(RESULT_OK, Intent().apply { putExtra(Intent.EXTRA_TEXT, text) })
        }
        finish()
    }

}}
class NewPostContractEdited : ActivityResultContract<String, String?>() {
    override fun createIntent(context: Context, input: String): Intent =
        Intent(context, NewPostActivity::class.java)
            .putExtra(Intent.EXTRA_TEXT, input)


    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return if (resultCode == Activity.RESULT_OK) {
            intent?.getStringExtra(Intent.EXTRA_TEXT)
        } else {
            null
        }
    }


}