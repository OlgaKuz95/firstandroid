package ru.netology.nmedia.utils

import kotlin.Int


object Calculator {

    var likeCount = 999
    var shareCount = 0

    fun convert(count: Int): String {
        return when {
            count >= 1000 -> "1K"
            else -> count.toString()
        }

    }
}




