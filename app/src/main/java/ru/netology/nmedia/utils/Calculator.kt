package ru.netology.nmedia.utils

import kotlin.Int


object Calculator {

    var likeCount = 0
    var shareCount = 0

    fun convert(count: Int): String {
        return when {
            count in 1_000..9_999  -> String.format("%.1fК", count / 1000f )
            count in 10_000..99_999 -> "${count/1000}K"
            count in 100_000 .. 999_999 ->"${count/1000 }K"
          count in 1_000_000.. 9_999_999 ->String.format("%.1fМ", count / 1_000_000f )
            count >= 10_000_000-> "10м"
            else -> count.toString()
        }

    }
}







