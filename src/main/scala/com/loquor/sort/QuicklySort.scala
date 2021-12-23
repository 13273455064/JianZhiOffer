package com.loquor.sort

object QuicklySort {


  def main(args: Array[String]): Unit = {
    val arr = Array(2, 4, 3, 6, 7, 2, 9, 5, 23, 32, 12, 555, 123, 32, 765);
    val length = arr.length
    val start = System.currentTimeMillis();
    sort(arr, 0, length - 1)
    println(arr.mkString("Array(", ", ", ")"))
    println(System.currentTimeMillis() - start)
  }

  def sort(arr: Array[Int], start: Int, end: Int): Unit = {
    if (start > end) {
      return
    }
    val temp = arr(start)
    var left = start
    var right = end

    while (left < right) {

      while (left < right && arr(right) > temp) {
        right = right - 1
      }

      if (left < right) {
        arr(left) = arr(right);
        left = left + 1
      }

      while (left < right && arr(left) >= temp) {
        left = left + 1
      }

      if (left < right) {
        arr(right) = arr(left)
        right = right - 1
      }
    }
    arr(left) = temp
    sort(arr, start, left - 1)
    sort(arr, left + 1, end)
  }
}
