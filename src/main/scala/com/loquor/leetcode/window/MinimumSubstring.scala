package com.loquor.leetcode.window

/**
 * 滑动窗口的最小覆盖字符串
 *
 * https://leetcode.cn/problems/minimum-window-substring/
 */
object MinimumSubstring {

  def main(args: Array[String]): Unit = {
    val s = "ADOBECODEBANC"
    val t = "ABC"

    println(minWindow(s, t))
  }

  def minWindow(s: String, t: String): String = {
    // map 放的是字符出现的次数，窗口和 t 中都可能会出现重复的字符
    val need = collection.mutable.Map.empty[Char, Int]
    val window = collection.mutable.Map.empty[Char, Int]

    t.toCharArray.foreach(c => need.put(c, need.getOrElse(c, 0) + 1))

    var left = 0
    var right = 0
    var start = 0
    var len = Int.MaxValue
    // 窗口中出现 t 字符串字符的个数
    var existCount = 0;

    while (right < s.length) {
      val c = s.charAt(right)
      // 先增大窗口
      right = right + 1

      if (need.contains(c)) {
        window.put(c, window.getOrElse(c, 0) + 1)
        // 当某一个字符在父字符串中全部找到时
        if (need.get(c) == window.get(c)) {
          existCount = existCount + 1
        }
      }

      // 当找到足够数量的 t 的字符之后，也就是满足覆盖字串的时候，开始减小窗口
      while (existCount == need.size) {
        val cc = s.charAt(left)

        //如果是更小的符合条件的字串,需要更新 字串的索引位置
        if (right - left < len) {
          start = left
          len = right - left
        }

        left = left + 1

        if (need contains cc) {

          if (need.get(c) == window.get(c)) {
            existCount = existCount - 1
          }

          window.put(cc, window.getOrElse(cc, 0) - 1)
        }

      }

    }

    if (len == Int.MaxValue) ""
    else s.substring(start, start + len)
  }

}
