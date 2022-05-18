package com.loquor.jianzhioffer

/**
 * <p>
 *
 * </p>
 *
 * @author zhengzhicong
 * @since 2021/8/8 10:39 上午
 */
object No1 {

  def main(args: Array[String]): Unit = {
    val array: Array[Array[Int]] = Array.ofDim(3, 4)
    array(0) = Array(1, 2, 3, 4)
    array(1) = Array(5, 6, 7, 8)
    array(2) = Array(9, 10, 11, 12)
    array.foreach(arr => {
      arr.foreach(a => {
        print(a)
        print(",")
      })
      println(" ")
    })
    val i: Int = find(array, 0)
    println(i)
  }

  def find(array: Array[Array[Int]], a: Int): Int = {
    var row = array.length - 1
    var col = 0
    var finder = -1

    while (row >= 0 && col <= array(1).length - 1) {
      val b = array(row)(col)
      if (b == a) {
        finder = b
      }
      if (b > a) row = row - 1 else col = col + 1
    }
    finder
  }

}
