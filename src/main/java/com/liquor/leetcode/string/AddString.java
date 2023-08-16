package com.liquor.leetcode.string;


/**
 * 字符串相加
 * <p>
 * https://leetcode.cn/problems/add-strings/description/
 */
public class AddString {
    public static void main(String[] args) {

        var a = "123";
        var b = "987";

        System.out.println(addString2(a, b));

    }

    static String addString2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? Integer.parseInt(String.valueOf(num1.charAt(i))) : 0;
            int y = j >= 0 ? Integer.parseInt(String.valueOf(num2.charAt(j))) : 0;
            int result = x + y + add;
            ans.insert(0, result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return ans.toString();
    }

}
