package com.liquor.leetcode.array;

/**
 * 反转字符数组
 * https://leetcode.cn/problems/reverse-string/
 * 双指针
 */
public class ReverseCharArray {
    public static void main(String[] args) {
        var arr = new char[]{'h', 'e', 'l', 'l', 'o'};

        reverse(arr);

        for (char c : arr) {
            System.out.println(c);
        }
    }

    static void reverse(char[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            var swap = array[right];
            array[right] = array[left];
            array[left] = swap;
            left++;
            right--;
        }

    }
}
