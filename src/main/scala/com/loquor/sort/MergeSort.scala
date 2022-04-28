package com.loquor.sort

object MergeSort {

  def mergedSort[T](less: (T, T) => Boolean)(list: List[T]): List[T] = {


    def merged(xList: List[T], yList: List[T]): List[T] = {
      (xList, yList) match {
        case (Nil, _) => yList
        case (_, Nil) => xList
        case (x :: xTail, y :: yTail) => {
          if (less(x, y)) {
            x :: merged(xTail, yList)
          } else {
            y :: merged(xList, yTail)
          }
        }
      }
    }

    val mid = list.length / 2
    if (mid == 0) list
    else {
      val (x, y) = list splitAt mid
      val xList = mergedSort(less)(x)
      val yList = mergedSort(less)(y)
      merged(xList, yList)
    }
  }

  def main(args: Array[String]): Unit = {
    val list = List(2, 3, 1, 5, 8, 32, 4, 100, 7, 6, 11)
    println(mergedSort((x: Int, y: Int) => x < y)(list))
  }
}
