package ru.netology.nmedia.utils

import kotlin.Int


object Calculator {

    var likeCount = 5550
    var shareCount = 0

    fun convert(count: Int): String {
        return when {
            count in 1_000..9_999  -> ("${count / 1000}К")
            count in 10_000..99_999 -> "${count/1000}K"
            count in 100_000 .. 999_999 ->"${count/1000 }K"
          count in 1_000_000.. 9_999_999 -> "${count/1_000_000.0}М"
            count >= 10_000_000-> "10м"
            else -> count.toString()
        }

    }
}







