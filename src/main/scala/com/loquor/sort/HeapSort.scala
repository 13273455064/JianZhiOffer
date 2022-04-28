package com.loquor.sort


object HeapSort {

  def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val t = a(i)
    a(i) = a(j)
    a(j) = t
  }


  def adjustHeap(array: Array[Int], current: Int, size: Int): Unit = {
    val left = current * 2 + 1
    val right = left + 1;
    var max = current

    if (left < size && array(max) < array(left)) {
      max = left
    }

    if (right < size && array(max) < array(right)) {
      max = right
    }
    if (max != current) {
      swap(array, max, current)
      adjustHeap(array, max, size)
    }
  }


  def buildMaxHeap( a: Array[Int], size: Int): Unit = {
    val hs = size / 2
    for (i <- 0 to hs) {
      adjustHeap(a, hs - i, size)
    }
  }

  def heapSort(a: Array[Int]): Unit = {
    buildMaxHeap(a, a.length)
    for (i <- a.indices.reverse) {
      swap(a, 0, i)
      adjustHeap(a, 0, i)
    }
  }

  def main(args: Array[String]): Unit = {
    val data = Array(2, 3, 1, 5, 8, 32, 4, 100, 7, 6, 11)
    heapSort(data)
    println(data.mkString("Array(", ", ", ")"))
  }

}
