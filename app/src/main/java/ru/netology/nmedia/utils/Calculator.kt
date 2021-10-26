package ru.netology.nmedia.utils


object Calculator {


    var likeCount = 1001
    var shareCount = 0
    fun convert(count: Count): String {

        //  if (count.likeCount  > 1000){
        //  return "1к"
        // }
        // else if (count.likeCount < 1000){
        //  return likeCount.toString()
        // }else if (count.shareCount > 1000){
        // return "1к"
        //}
        //else  {
        // return shareCount.toString()
        //  }

        return when {
            count.likeCount > 1000 -> "1к"
            count.likeCount <= 1000 -> likeCount.toString()
            count.shareCount > 1000 -> "1к"
            else -> shareCount.toString()

        }

    }
}







