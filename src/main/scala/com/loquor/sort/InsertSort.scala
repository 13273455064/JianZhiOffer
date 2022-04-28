package com.loquor.sort

object InsertSort {

  def main(args: Array[String]): Unit = {
    val arr = Array(2, 3, 1, 5, 8, 32, 4, 100, 7, 6, 11)
    val length = arr.length

    def swap(a: Int, b: Int): Unit = {
      val temp = arr(a)
      arr(a) = arr(b)
      arr(b) = temp
    }

    for (i <- 0 until length) {
      for (j <- 0 until i) {
        if (arr(i) < arr(j)) swap(i,j)
      }
    }

    println(arr.mkString("Array(", ", ", ")"))
  }

}
