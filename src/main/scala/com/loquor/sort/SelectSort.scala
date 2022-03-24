package com.loquor.sort


object SelectSort {


  def main(args: Array[String]): Unit = {
    val arr = Array(2, 3, 1, 5, 4, 7, 6, 11)

    val length = arr.length

    var temp = -1
    for (i <- 0 until length) {
      var minIndex = i
      for (j <- i + 1 until length) {
        if (arr(minIndex) > arr(j)) {
          minIndex = j
        }

        if (j == length - 1) {
          temp = arr(minIndex)
          arr(minIndex) = arr(i)
          arr(i) = temp
        }
      }
    }
    println(arr.mkString("Array(", ", ", ")"))
  }
}
