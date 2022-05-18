package com.loquor.leetcode

/**
 * 斐波那契数列问题
 */
object No509 {


  def main(args: Array[String]): Unit = {
    println(fib3(4))
  }

  /**
   * 带备忘录的递归解法，自顶向下
   */
  def fib(n: Int): Int = {
    val mono = Array.ofDim[Int](n + 1)

    def dp(mono: Array[Int], n: Int): Int = {
      n match {
        case 0 => 0
        case 1 => 1
        case 2 => 1
        case _ =>
          val cache = mono(n)
          if (cache > 0) {
            cache
          } else {
            val res = dp(mono, n - 1) + dp(mono, n - 2)
            mono(n) = res
            res
          }
      }
    }

    dp(mono, n)
  }

  /**
   * 自底向上
   */
  def fib2(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ =>
        val dp = Array.ofDim[Int](n + 1)
        dp(0) = 0
        dp(1) = 1
        for (i <- 2 to n) {
          dp(i) = dp(i - 1) + dp(i - 2)
        }
        dp(n)
    }
  }

  /**
   * 自底向上,进一步节省空间
   */
  def fib3(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ =>
        var dp_n_1 = 1
        var dp_n_2 = 0
        for (_ <- 2 to n) {
          val dp_n = dp_n_1 + dp_n_2
          dp_n_2 = dp_n_1
          dp_n_1 = dp_n
        }
        dp_n_1
    }
  }


}
