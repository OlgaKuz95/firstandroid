package ru.netology.nmedia.utils

import kotlin.Int


object Calculator {

    var likeCount = 550_550
    var shareCount = 0

    fun convert(count: Int): String {
        return when {
            count in 1_000..9_999  -> "${count/1_000f} K"
            count in 10_000..99_999 -> "${count/10_000f}к"
            count in 100_000 .. 999_999 ->"${count/100_000f }K"
          count in 1_000_000.. 9_999_999 -> "${count/1_000_000f} м"
            count >= 10_000_000-> "10м"
            else -> count.toString()
        }

    }
}




