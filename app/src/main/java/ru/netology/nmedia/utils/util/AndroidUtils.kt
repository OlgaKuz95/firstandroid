package ru.netology.nmedia.utils.util

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

object AndroidUtils {
    fun hideKeyboard(view: EditText){
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }


}