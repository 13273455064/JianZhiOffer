package com.loquor.sort

object BubbleSort {

  def main(args: Array[String]): Unit = {
    val arr = Array(2, 4, 3, 6, 7, 5, 2, 1, 9, 10)
    val length = arr.length

    def swap(a: Int, b: Int): Unit = {
      val temp = arr(a)
      arr(a) = arr(b)
      arr(b) = temp
    }

    for (i <- 0 until length) {
      for (j <- i until length) {
        if (arr(i) > arr(j)) {
          swap(i, j)
        }
      }
    }

    println(arr.mkString("Array(", ", ", ")"))
  }
}
